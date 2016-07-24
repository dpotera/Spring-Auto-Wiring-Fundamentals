package saw.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

/*
*   My own Qualifier @Annotation:  @Invest
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Context where @Annotation is applicable
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
// How long @Annotation will be retained
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Invest {
}
