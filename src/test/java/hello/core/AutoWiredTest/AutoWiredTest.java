package hello.core.AutoWiredTest;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

//    @Test
//    @DisplayName("주입 테스트")
//    void InjectionTest(){
//        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
//        orderService.createOrder(2L,"컴퓨터",10000);
//
//    }



    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

  static class TestBean{
        @Autowired(required = false)
        public void SetNoBean1(MemberService noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void SetNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void SetNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}

