package org.example.scan.filter;

import java.lang.annotation.*;

// 컴포넌트에 붙어있는 어너테이션

@Target(ElementType.TYPE) // 중요함
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
