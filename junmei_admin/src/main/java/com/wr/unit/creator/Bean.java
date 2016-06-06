package com.wr.unit.creator;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by wangrui on 2015/5/12.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Bean {
    String pn() default "";//packageName;
    String dn() default "";// database Name;
}
