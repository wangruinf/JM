package com.wr.unit.test;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

/**
 * Created by wangrui on 2015/4/28.
 */
public class MyTest {


    private static PathMatcher pathMatcher = new AntPathMatcher();
    public static void  main(String argv[]){




        String  packageName = " com.wr.unit.test.MyTest";

        String packageDirName="classpath*:" +  packageName.replace('.', '/');
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        try{


            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
            Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents("com/wr/unit/");
            for (BeanDefinition beanDefinition : beanDefinitions) {

                if( beanDefinition instanceof AnnotatedBeanDefinition ){
                    AnnotatedBeanDefinition annDef = (AnnotatedBeanDefinition) beanDefinition;
                    for(String s : annDef.getMetadata().getAnnotationTypes()){
                        if( "org.springframework.stereotype.Controller".equals(s)){
                            System.out.println("className : " + beanDefinition.getBeanClassName());
                            System.out.println("   method anno has Controller: >>");
                            for(MethodMetadata metadata : annDef.getMetadata().getAnnotatedMethods("org.springframework.web.bind.annotation.RequestMapping") ){
                                System.out.println("\t\t" + metadata.getMethodName());
                            }
                        }
                    }






                }
               // System.out.println( beanDefinition.getBeanClassName());


            }

          //  Resource[] resources = resourcePatternResolver.getResources("classpath*:com/wr/unit/**/*.class");


           // for (Resource resource: resources){
               // System.out.println(resource.getInputStream().getName());
                //System.out.println(resource.getClass().getAnnotations());
              //  for(Annotation annotation : resource.getClass().getAnnotations()){
                 //   System.out.println(annotation.getClass().getName());
              //  }
                //System.out.println( Arrays.toString(resource.getClass().getAnnotations() ));
          //  }
        }catch (Exception ie){
            ie.printStackTrace();
        }

         /**
        int prefixEnd = location.indexOf(":") + 1;
        int rootDirEnd = location.length();
        while (rootDirEnd > prefixEnd && pathMatcher.isPattern(location.substring(prefixEnd, rootDirEnd))) {
    System.out.println(location.lastIndexOf('/', rootDirEnd -2) + "ddd");
            System.out.println(location.lastIndexOf('/', rootDirEnd ));
            rootDirEnd = location.lastIndexOf('/', rootDirEnd -2) + 1;

        }
        if (rootDirEnd == 0) {
            rootDirEnd = prefixEnd;
        }**/

     //   System.out.println(location.substring(0, rootDirEnd));
    }

}
