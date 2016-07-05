package org.jor.productinventory.business;

import java.lang.annotation.*;

/**
 * Created by j4mt on 04/07/16.
 *
 */
//todo: come back and revisit impleting your own anotations to map data to entitys to store in the file system
@Documented
@Target(ElementType.CONSTRUCTOR)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductDetails {

    String code() default "00000000";
    String description() default "No description";
    double price() default 0.0;
}
