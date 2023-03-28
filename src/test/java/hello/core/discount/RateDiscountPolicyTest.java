package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야 한다.")
    void vip_o(){
        Member memberVip =  new Member(1L, "memberVIP", Grade.VIP);
        int discount = rateDiscountPolicy.dicount(memberVip, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니라면 할인 적용 X")
    void vip_x(){
        Member normal = new Member(2L, "memberNORMAL", Grade.BASIC);
        int discount = rateDiscountPolicy.dicount(normal, 10000);

        assertThat(discount).isEqualTo(0);
    }

}