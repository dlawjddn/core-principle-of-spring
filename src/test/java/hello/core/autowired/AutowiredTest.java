package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{
        @Autowired(required = false) // 기본 옵션인 경우 : Member가 빈으로 등록 되지 않아서 오류가 뜸
        //(required = false)인 경우 : Member가 빈으로 등록 안돼서 메서드 호출 자체 안 함
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired //호출은 되는데 null로 나옴
        public void setNoBean2(@Nullable  Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired // Optional은 null 와 값을 모두 확인할 수 있음, null이면 Optional.empty 아니라면 값을 출력
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
