package hello.basic;

import hello.basic.member.Grade;
import hello.basic.member.Member;
import hello.basic.member.MemberService;
import hello.basic.order.Order;
import hello.basic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        System.out.println(memberService.findMember(1L) == member);

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Order order = orderService.createOrder(1L, "memberA", 20000);
        int discountPrice = order.getDiscountPrice();

        System.out.println(discountPrice);
    }
}
