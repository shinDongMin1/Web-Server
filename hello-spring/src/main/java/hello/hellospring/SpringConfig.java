package hello.hellospring;
/* 자바 코드로 직접 스프링빈 등록: 자동스캔에서 문제가 생길 경우 여기서 조정후 서버열음 ex) DB를 바꿀려고할때 쉽게할수 있다 */

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //@Autowired private final DataSource dataSource;
    //private final DataSource dataSource;
    //@PersistenceContext //스프링부트에서 bean처럼 영속성 컨텍스트에 의해 객체(member)가 DB와 관리되고 있는 상태
    //private final EntityManager em;
    private final MemberRepository memberRepository;


    //    public SpringConfig(DataSource dataSource) {this.dataSource = dataSource;}
    //    public SpringConfig(EntityManager em) {this.em = em;}
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop ();
    }

    //@Bean
    //public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository (dataSource);
        //return new JdbcTemplateMemberRepository (dataSource);
        //return new JpaMemberRepository (em);
    //}
}