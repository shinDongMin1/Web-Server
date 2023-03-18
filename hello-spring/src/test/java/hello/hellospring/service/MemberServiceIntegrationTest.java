package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest // 전에는 자바코드상에서 테스트했지만 실제로 스프링읗 띄어서 테스트함
@Transactional // 디폴트인 auto-comm을 테스트한 후에 rollback한다.
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given: 상황에서
        Member member = new Member ();
        member.setName ("spring");

        //when: 실행했을때
        Long result = memberService.join (member);

        //then: 결과는?
        Member fingMember = memberService.findOne (result).get ();
        Assertions.assertThat (member.getName ()).isEqualTo (fingMember.getName ());
    }

    @Test
    public void 중복_회원_예외() {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        /*
        try {
            memberService.join(member2);
        }catch (IllegalStateException e){ assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");}
        */
        IllegalStateException e = assertThrows (IllegalStateException.class, () -> memberService.join (member2));//예외가 발생해야 한다.
        // 람다함수에서 앞에 있는 예외가 터져야해

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}