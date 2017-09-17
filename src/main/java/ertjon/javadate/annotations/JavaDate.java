package ertjon.javadate.annotations;

import ertjon.javadate.processors.JavaDateParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jboss.resteasy.annotations.StringParameterUnmarshallerBinder;

/**
 *
 * @author Ertjon
 */
@Retention(RetentionPolicy.RUNTIME)
@StringParameterUnmarshallerBinder(JavaDateParser.class)
public @interface JavaDate {
    String value() default "dd/MM/yyyy";
}
