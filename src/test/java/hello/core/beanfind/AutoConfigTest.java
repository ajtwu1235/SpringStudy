package hello.core.beanfind;

import hello.core.AutoConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoConfigTest {



    @Test
    @DisplayName("자동등록 테스트")
    void AutoConfig(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThat(bean).isInstanceOf(MemberRepository.class);
    }

}
