package com.wr.unit.creator;

import com.google.common.base.Splitter;
import org.springframework.util.StringUtils;

/**
 * Created by wangrui on 2015/5/12.
 */
public class Context {
    public Class beanClass;
    public static final String PATH_JAVA = "java";
    public static final String PATH_JSP = "jsp";
    public static final String PATH_DB = "db";
    public static final String PATH_CONFIG = "config";

    public static final String PACK_ENTITY = "entity";
    public static final String PACK_DAO  = "dao";
    public static final String PACK_SERVICE = "service";
    public static final String PACK_WEB  = "web";

    private String outPath;
    private String packageStr;
    private String packagePath;
    private String absolutePackagePath;
    public Context(String outPath, String packageStr, Class clazz){
        this.outPath = outPath;
        this.packageStr = packageStr;
        this.setPackagePath(StringUtils.replace(packageStr, ".", "/"));
        this.beanClass = clazz;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getPackagePath() {
        return packagePath;
    }


    public String getPackEntityPath() {
        return this.getJAVAPath() + packagePath + "/" + PACK_ENTITY;
    }

    public String getPackDaoPath() {
        return this.getJAVAPath() + packagePath + "/" + PACK_DAO;
    }

    public String getPackServicePath() {
        return this.getJAVAPath() + packagePath + "/" + PACK_SERVICE;
    }


    public String getPackWebPath() {
        return this.getJAVAPath() + packagePath + "/" + PACK_WEB;
    }

    public String getPackEntity() {
        return this.packageStr  + "." + PACK_ENTITY;
    }

    public String getPackDao() {
        return this.packageStr  + "." + PACK_DAO;
    }

    public String getPackService() {
        return this.packageStr  + "." + PACK_SERVICE;
    }


    public String getPackWeb() {
        return this.packageStr  + "." + PACK_WEB;
    }

    public String getJAVAPath() {
        return this.outPath + "/" + PATH_JAVA + "/";
    }

    public String getJSPPath() {
        return this.outPath + "/" + PATH_JSP + "/";
    }

    public String getDBPath() {
        return this.outPath + "/" + PATH_DB + "/";
    }

    public String getCONFIGPath() {
        return this.outPath + "/" + PATH_CONFIG + "/";
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getAbsolutePackagePath() {
        return absolutePackagePath;
    }

    public void setAbsolutePackagePath(String absolutePackagePath) {
        this.absolutePackagePath = absolutePackagePath;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
