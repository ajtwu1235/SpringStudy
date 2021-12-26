package hello.core.discount;

import hello.core.AutoConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy =new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야한다.")
    void vip_o(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.Discount(memberA, 10000);
        //then

        Assertions.assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP가 아니면 적용되면 안된다.")
    void vip_x(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discount = discountPolicy.Discount(memberA, 10000);
        //then

        Assertions.assertThat(discount).isEqualTo(0);
    }


}