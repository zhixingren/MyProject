package com.mysummary.myproject.java_basis.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xingzhi on 2018/4/12.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    int value();
}
