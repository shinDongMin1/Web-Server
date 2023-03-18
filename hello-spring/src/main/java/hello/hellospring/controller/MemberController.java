package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 멤버컨트롤러가 생성될때 스프링빈에 등록되어 잇는 멤버서비스객체를 가져가 넣어줌(의존주사) dependency injection
    // DI의 방법: 1.생성자 2.필드 3.setter
    @Autowired
    public MemberController(MemberService memberService) {
           this.memberService = memberService;
    }
    //private final MemberService memberService;
    /*
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member ();
        member.setName (form.getName ());

        memberService.join (member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMember ();
        model.addAttribute ("members", members);

        return "members/memberList";
    }
}
