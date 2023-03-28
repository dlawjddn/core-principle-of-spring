package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void creatOrder(){
        // 수정자 주입으로 돌리면 널포인트인셉션 발생 (수정자 주입을 했는데 값을 안 넣어줬기 때문이다.)
        // 생성자 주입으로 돌리면 컴파일 오류 발생 : 역시 값이 없기 때문이다. => 빠른 파악 가능
        // OrderServiceImpl orderService = new OrderServiceImpl();
        // orderService.createOrder(1L, "itemA", 10000);

        // 결론 => 오류 파악 쉬운 생성자 주입을 사용하자! & 생성자 주입을 사용하면 final 키워드를 사용할 수 있고, 이게 실수를 막아줄 수 있다!

        // 테스트 성공을 위한 더미 코드
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "asjdlakd", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}