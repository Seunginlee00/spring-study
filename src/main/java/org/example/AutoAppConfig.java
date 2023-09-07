package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "org.example",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    // basePackages로 메인 페키지를잡고
    //exclude로 필요없는걸 빼가면서 코딩하는걸 추천
//    컴포넌트 스캔은 @Component 뿐만 아니라 다음과 내용도 추가로 대상에 포함한다.
//    @Component : 컴포넌트 스캔에서 사용
//    @Controller : 스프링 MVC 컨트롤러에서 사용하고 인식
//    @Service : 스프링 비즈니스 로직에서 사용 0> 개발자들이 비즈니스 로직이 여 있다.. 서비스다.. 라고 구분하는 용도.. 딱히 하는 일은 없음
//    @Repository : 스프링 데이터 접근 계층에서 사용 -> 접근 계층으로 인식 추상화된 예외로 바꿔줌 -> 예외를 리포지단에서 처리할 수 있도록 해줌
//    @Configuration : 스프링 설정 정보에서 사용 -> 싱글톤 유지 설정  스프링 정보로 인식
}
