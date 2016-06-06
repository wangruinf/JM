package com.wr.unit.creator;

import com.wr.unit.creator.jsp.CodeComments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wangrui on 2015/5/15.
 */
public class CreateEntity implements Creator{
    Context context;
    public void CreateEntity(Context context){
        this.context = context;
    }


    @Override
    public void create() {
        StringBuffer sb = new StringBuffer();
        Class c = context.getBeanClass();

        CodeComments codeComments = (CodeComments) c.getAnnotation(CodeComments.class);

        sb.append("package " + context.getPackEntity() + ";\n\n\n")
                .append("/**\n").append("*"  ).append(codeComments).append("*/");

        sb.append("public class").append(context.getBeanClass().getSimpleName())
                .append(" implements java.io.Serializable{\n\n");

        for(Field field : context.getBeanClass().getDeclaredFields()){
            sb.append("\t").append("private ").append(field.getType()).append(" ").append(field.getName()).append(";");
        }

        for(Method method : c.getMethods()){
            //sb.append("\t").append("public ").append(method.getReturnType().getSimpleName()).append("()").append(field.getName()).append(";");
        }
        sb.append("\n");
    }
}
