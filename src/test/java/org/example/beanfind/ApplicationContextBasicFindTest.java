package org.example.beanfind;
import org.example.AppConfigSpring;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfigSpring.class);
    @Test
    @DisplayName("빈 이름으로 조회") void findBeanByName() {
        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회") void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회") void findBeanByName2() {
        // 인터페이스를 보고 참고 해서 이걸로 검색이 가능함
        // but 분리가 돼지 않아 좋지 않은 코드
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X") void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class); -> 실패 코드
        // 이런 이름의 빈코드는 없어!
        // 아래 문법은 람다
        // 아래 코드를 입력시 NoSuchBeanDefinitionException 의 에러가 나는지 
        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxx", MemberService.class));
    }

}
