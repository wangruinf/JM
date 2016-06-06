package com.wr.unit.creator;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import org.springframework.util.FileCopyUtils;

import javax.persistence.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangrui on 2015/5/12.
 */
public class CreateHibXml implements Creator {

    private Context context;

    public CreateHibXml(Context context) {
        this.context = context;
    }

    @Override
    public void create( ) {
        Class c = this.context.getBeanClass();
        ClassBeanHibAnno classBeanHibAnno = new ClassBeanHibAnno(context, c);
        classBeanHibAnno.jx();
    }
}


class ClassBeanHibAnno{
    private StringBuffer sb = new StringBuffer(2000);
    private Context ctx;
    private Class c;

    public ClassBeanHibAnno(Context ctx, Class c){
        this.c = c;
        this.ctx = ctx;
    }

    public void jx(){
        this.createHeadel();
        this.createClass();
        this.createId();
        this.createProperty();
        this.createFoot();
        File f = new File(ctx.getPackEntityPath() + "/" + c.getSimpleName() + ".hbm.xml");
        try {
            FileCopyUtils.copy(sb.toString(), new OutputStreamWriter(new FileOutputStream(f)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHeadel(){
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mapping DTD 2.0//EN\" \"http://hibernate.sourceforge.net/hibernate-mapping-2.0.dtd\">\n" +
                "<hibernate-mapping>\n");
    }
    public void createFoot(){
        sb.append("</class>\n</hibernate-mapping>");
    }

    public void createClass(){
        Table ta = (Table) c.getAnnotation(Table.class);
        String tableName = ta.name();
        String schema =    ta.schema();

        if( Strings.isNullOrEmpty(tableName) ) tableName = CreatorUtils.cnToDtn(c.getSimpleName());
        sb.append("<class name=\"" + ctx.getPackEntity() + "." + c.getSimpleName() + "\" schema=\"" + schema + "\" table=\"" +  tableName + "\">\n");
    }
    public void createId(){
        String idStr = "";
        Method[] methods = c.getMethods();
        for(Method method : methods){
            if( method.getName().startsWith("get")) {
                Id id = (Id) method.getAnnotation(Id.class);
                if( id != null){
                    GeneratedValue generatedValue = (GeneratedValue)method.getAnnotation(GeneratedValue.class);
                    if( generatedValue != null ) {
                        String fname = CreatorUtils.mnToDd(method.getName());
                        String type = JavaToHibernateTypes.getType(method.getReturnType());
                        idStr = "\t<id column=\"" + CreatorUtils.fnToDd(fname)  + "\" name=\"" +  fname + "\" type=\"" + type + "\">\n\t";
                        if(generatedValue.strategy() == GenerationType.SEQUENCE )
                        idStr += "\t<generator class=\"sequence\">\n" +
                                "\t\t\t<param name=\"sequence\">" + generatedValue.generator() + "</param>\n" +
                                "\t\t</generator>\n\t</id>\n\n";

                    }else{
                        System.out.println("generatedValue  is NULL!!");
                    }
                }
            }
        }
        sb.append(idStr);
    }
    public void createProperty(){

        String propertyStr = "";
        Method[] methods = c.getMethods();
        for(Method method : methods){

            if( method.getName().startsWith("get")){

                Column column = (Column)method.getAnnotation(Column.class);
                if( column != null ) {

                    String columnName =Strings.isNullOrEmpty(column.name()) == false ?  column.name()  : CreatorUtils.mnToDd(method.getName());

                    propertyStr = "\t<property column=\"" + CreatorUtils.fnToDd(columnName)  + "\" name=\"" +  CreatorUtils.mnToDd(method.getName()) + "\"";

                    String type = JavaToHibernateTypes.getType(method.getReturnType());
                    if( Strings.isNullOrEmpty( type ) ){
                        type = "ERROR";
                        System.out.println("  -----------ERROR---------- ");
                        System.out.println(c.getCanonicalName() + "-->" + CreatorUtils.mnToDd(method.getName()) + "没有对应的数据类型");
                    }else{
                        propertyStr += " type=\"" + type + "\"";
                    }

                    if(column.unique() == true ) propertyStr += " unique=\"true\"";
                    if(column.updatable() == false ) propertyStr += " update=\"false\"";
                    if(column.insertable() == false ) propertyStr += " insert=\"false\"";
                    if(column.nullable() == false) propertyStr += " not-null=\"false\"";

                    if("string".equals(type)) propertyStr += " length=\"" + column.length() +"\"";

                    propertyStr +="/>\n";
                    sb.append(propertyStr);
                }
            }
        }

    }

}
class hibColumn{

}

class JavaToHibernateTypes{
    public static final Map<Class, String> types = new HashMap<Class, String>();
    static {
        types.put(Integer.class, "integer");
        types.put(Long.class, "long");
        types.put(Short.class, "short");
        types.put(Float.class, "float");
        types.put(Double.class, "double");
        types.put(Character.class, "character");
        types.put(Byte.class, "byte");
        types.put(Boolean.class, "boolean");
        types.put(java.util.Date.class, "date");
        types.put(java.sql.Time.class, "time");
        types.put(java.sql.Timestamp.class, "timestamp");
        types.put(java.sql.Clob.class, "clob");
        types.put(java.sql.Blob.class, "blob");
        types.put(String.class, "string");
    }
    public static String getType(Class clazz){
        return types.get(clazz);
    }
}