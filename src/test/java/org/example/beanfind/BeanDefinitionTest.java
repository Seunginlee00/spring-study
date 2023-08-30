package org.example.beanfind;

import org.example.AppConfigSpring;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfigSpring.class);


    //GenericXmlApplicationContext ac = new
    //GenericXmlApplicationContext("appConfig.xml");
    // 얘네는 명확하게 등록되어 있음 -> 팩소리메소드?그런게빠져 있는데 자바 config으로 바뀌면서


    // 직접 등록 -> xml
    // 두번째 자바팩토리 사용 -> 자바 config : 메소드를 사용하는 방식


    // 할당이 돼지 않았으면 싱글톤으로 부름
    // 이런 메타 정보가 있고 메타정보를 기본으로 인스턴스를 만들 수 있음


    @Test
    @DisplayName("빈 설정 메타정보 확인") void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // 이름들을 먼저 꺼냄

        for (String beanDefinitionName : beanDefinitionNames) {
            // 정보를 얻을 수 있음
            BeanDefinition beanDefinition =
                    ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName" + beanDefinitionName +
                        " beanDefinition = " + beanDefinition);
            }
        }
    }
}


