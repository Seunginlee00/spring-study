package org.example.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new
                AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //로직을 부른게 없음..
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
        // 원래쓰는거 말고 저 컨피그 를 써야함 close를 지원 안해줌..

    }

    @Configuration
    static class LifeCycleConfig {
        //(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            // 에너테이션 방식은 java 공식에서 지원 ㅎ해주는 기술임
            // javax는 공식에서 적용.. 외부 라이브러리는 사용하지 못하지만 아까 배운 저 init 을 사툥하면 된당~
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
