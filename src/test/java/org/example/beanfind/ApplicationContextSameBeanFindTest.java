package org.example.beanfind;
import org.example.meber.MemberRepository;
import org.example.meber.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다") void findBeanByTypeDuplicate() {
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        //NoUniqueBeanDefinitionException 해당 에러가 납니다  -> 빈이름이 똑같다는 오류
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다") void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1",
                MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        //command shfit enter
        // 키밸류
        Map<String, MemberRepository> beansOfType =
                ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " +
                    beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }





    //static 이안에서만 사용할 거다.
    @Configuration
    static class SameBeanConfig {

        // 같은 빈이나 이름이 다를 순 있음
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

    @Bean
    public MemberRepository memberRepository2() {
        return new MemoryMemberRepository();
    }
}

}
