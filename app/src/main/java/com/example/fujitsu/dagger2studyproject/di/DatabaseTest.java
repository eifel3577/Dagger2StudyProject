package com.example.fujitsu.dagger2studyproject.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**Мы можем создавать свои аннотации и использовать их вместо @Named. */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseTest {
}