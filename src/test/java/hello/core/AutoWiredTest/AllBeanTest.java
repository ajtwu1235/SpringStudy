package hello.core.AutoWiredTest;

import hello.core.AutoConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);

        Member userA = new Member(1L, "userA", Grade.VIP);

        int fixDiscountPolicy = discountService.discount(userA, 10000, "fixDiscountPolicy");
        assertThat(fixDiscountPolicy).isEqualTo(1000);

        int rateDiscountPolicy = discountService.discount(userA, 20000, "rateDiscountPolicy");
        assertThat(rateDiscountPolicy).isEqualTo(2000);

    }


    // 이 클래스는 할인정책타입 빈들만 뽑아주는 클래스
    @RequiredArgsConstructor
  public   static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;

        public int discount(Member userA, int i, String bean) {
            DiscountPolicy discountPolicy = policyMap.get(bean);

            return discountPolicy.Discount(userA,i);
        }
    }
}
