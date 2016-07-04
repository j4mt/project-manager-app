package org.jor.productinventory.business;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by j4mt on 04/07/16.
 */

@Documented
@Target(ElementType.CONSTRUCTOR)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductDetails {
    String code() default "00000000";
    String description() default "No description";
    double price() default 0.0;
}
