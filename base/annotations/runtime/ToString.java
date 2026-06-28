package base.annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 运行时注解：标记在类上，打印对象时输出所有字段
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    String value() default "";
}
