package org.example.beanfind;

import org.example.discount.DiscountPolicy;
import org.example.discount.FixDiscountPolicy;
import org.example.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(TestConfig.class);

    // 부모를 조회할때 자식이 어디까지 조회되는지는 알고 있는 게 의존성 주입할때 도움이 됨.

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다") void findBeanByParentTypeDuplicate() {
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다") void findBeanByParentTypeBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",
                DiscountPolicy.class);
        //rateDiscountPolicy 실제로 오는 것
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회") void findBeanBySubType() {
        // 안좋은 방법
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회하기") void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType =
                ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            // 테스트는 출력 문으로 짜지 않음.
            // 통과 안한다 한다로 확인용만
            System.out.println("key = " + key + " value=" +
                    beansOfType.get(key));
        } }
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object") void findAllBeanByObjectType() {
        // 스프링 내부적 bean까지 다 조회됨
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value=" +
                    beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {

        // 의존관계 주입시에 역할과 구현을 쪼개 놓은 것이 훨씬 이해가 좋다.
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
