package cn.teach.common.mvc;

import java.lang.annotation.*;
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String name();
    String message() default "";
}
