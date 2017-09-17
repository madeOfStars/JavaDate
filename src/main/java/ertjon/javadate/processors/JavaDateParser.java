package ertjon.javadate.processors;

import ertjon.javadate.annotations.JavaDate;
import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jboss.resteasy.spi.StringParameterUnmarshaller;
import org.jboss.resteasy.util.FindAnnotation;

/**
 *
 * @author Ertjon
 */
public class JavaDateParser implements StringParameterUnmarshaller<Date>{
    private SimpleDateFormat dateFormatter;

    @Override
    public void setAnnotations(Annotation[] antns) {
        JavaDate javaDate = FindAnnotation.findAnnotation(antns, JavaDate.class);
        dateFormatter = new SimpleDateFormat(javaDate.value());
    }

    @Override
    public Date fromString(String string) {
        try{
            return dateFormatter.parse(string);
        } catch (ParseException e){
            try {
                return dateFormatter.parse("12/02/1991");
            } catch (ParseException ex) {
                return null;
            }
        }
    }
    
}
