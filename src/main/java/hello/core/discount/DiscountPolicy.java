package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //@return 할인된 금액
    int Discount(Member member , int price);
}
