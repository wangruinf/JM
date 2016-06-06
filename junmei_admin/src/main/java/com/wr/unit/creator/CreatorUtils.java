package com.wr.unit.creator;

import com.google.common.base.Strings;
import com.google.common.io.Files;
//import com.wr.unit.creator.model.*;
//import com.wr.unit.creator.model.ProjectBudget;
import org.springframework.util.StringUtils;
import com.google.common.base.CaseFormat;
import org.springframework.util.TypeUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by wangrui on 2015/5/12.
 */
public class CreatorUtils {
    // Filed Name TO  database Name (abcDefAb   -- > ABC_DEF_AB)
    public static String fnToDd(String fn){
        if( Strings.isNullOrEmpty(fn)) return "";
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fn);
    }
    // Method Name TO  database Name (abcDefAb   -- > ABC_DEF_AB)
    public static String mnToDd(String mn){

        StringBuffer sb = new StringBuffer(15);
        sb.append(Character.toLowerCase(mn.charAt(3)));
        sb.append(mn.substring(4));

        return sb.toString();
    }
    // class Nmae to table NAME
    public static String cnToDtn(String cn){
        if( Strings.isNullOrEmpty(cn)) return "";
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, cn) + "S";
    }

    public static void main(String argv []){
/**
        Class[] classes = new Class[]{
                ProjectTeamMember.class,
                OrganizationInfo.class,
                ProjectBudget.class,
                ProjectCapitalExpenditure.class,
                ProjectCapitalExpenditureItem.class,
                ProjectDeclaration.class,
                ProjectImplPlan.class,
                ProjectInfo.class,
                ProjectInfoGovernor.class,
                ProjectPublicService.class,
                ProjectSuccessQuota.class,
                ProjectTeam.class,
                ProjectTeamMember.class};
        Context context = null;
        for(Class c :classes){
            context = new Context("d:/create" , "com.topsuntech.gUnit.mszt.admin", c);
           // CreateJsp createJsp = new CreateJsp(context);
            //createJsp.create();
        }
        context = new Context("d:/create" , "com.topsuntech.gUnit.mszt.admin", ProjectTeamMember.class);
        Creator ch = new CreateHibXml(context);
        ch.create();**/
       /*
        Creator c = new CreatorPath(context);
        c.create();
        Creator ch = new CreateHibXml(context);
        ch.create();
        CreateHibXml classBeanHibAnno = new CreateHibXml(context);

        classBeanHibAnno.create();
**/



        //System.out.println(mnToDd("getName"));
     /**   System.out.println(StringUtils.replace("com.wr.unit.aa.ba" ,"." , "/"));

        String str = "d:/create/test/a.txt";
        try {
            Files.createParentDirs(new File(str));

        } catch (IOException e) {
            e.printStackTrace();
        }

      **/
        /**

        File file = new File(str);
        file.mkdirs();
        str += "a.txt";
        file = new File(str);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }**/

    }
}
