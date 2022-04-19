package com.mk.Annotations;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(METHOD) //--> basically indicates where we can add @Test
public @interface FrameworkAnnotations {

	String author() default "Test Automation Engineer";
	
	String[] category() default "smoke";
}
