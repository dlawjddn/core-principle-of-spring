package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
// 롬복에는 @Getter @Setter @NoArgsConstructor @RequiredArgsConstructor 등등의 애노테이션을 사용할 수 있다
// @Getter @Setter 는 우리가 아는 게터와 세터를 만들어주고
// @RequiredArgsConstructor 같은 경우는 final이 붙은 애들을 이용해서 생성자를 만들어준다(주석처리한 것과 똑같이!)
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
//    @Autowired
    //@Autowired가 조회 할 때 빈이 여러 개 있다면 (DiscountPolicy => FixDiscountPolicy, RateDiscountPolicy)
    //=> 빈 이름과 필드 명 또는 파라미터 명이 같은 것이 있나 파악한다 -> 있다면 그걸로 연결
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.dicount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
