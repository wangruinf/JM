package com.wr.unit.creator.jsp;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by wangrui on 2015/5/15.
 */
@Target({ElementType.FIELD,ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CodeComments {
    String comments() default "";
}
