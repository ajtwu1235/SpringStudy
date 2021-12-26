package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

   @Test
   @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
       MemberService memberService = ac.getBean("memberService", MemberService.class);
       Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
   }

    @Test
    @DisplayName("빈 조회 X")
    void findBeanByNameX(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxx",MemberService.class));
    }

}
