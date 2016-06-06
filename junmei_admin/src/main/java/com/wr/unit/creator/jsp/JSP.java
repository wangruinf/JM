package com.wr.unit.creator.jsp;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * fsd
 * dsf
 * dsCreated by f on 2015/5/13.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface JSP {
    String title() default "";
    int order() default 0;
}
