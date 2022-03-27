package hello.basic.singleton;

import hello.basic.AppConfig;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println(memberRepository);
        System.out.println(memberRepository1);
        System.out.println(memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository2);
    }
}
