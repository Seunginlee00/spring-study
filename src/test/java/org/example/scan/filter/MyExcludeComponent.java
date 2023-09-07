package org.example.scan.filter;
// 해당 어너테이션이 있으면 제외 할예정
import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
