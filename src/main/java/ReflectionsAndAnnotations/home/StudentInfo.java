package ReflectionsAndAnnotations.home;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
public @interface StudentInfo {
        // пример самописной аннотации с 3 полями

        String name() default "Default name";
        String surname() default "Default surname";

            int age()default 18 ;

    }

