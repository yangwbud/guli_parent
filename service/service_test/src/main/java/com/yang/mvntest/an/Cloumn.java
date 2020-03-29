package com.yang.mvntest.an;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cloumn {
    String value() default "info";
}
