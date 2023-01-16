package GDSC.Backend4th.controller;

import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.dto.MemberDto;
import GDSC.Backend4th.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    @GetMapping("/login")
    public String loginForm(@ModelAttribute MemberDto memberDto){
        return "member/loginMemberForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto){
        Member loginMember = memberService.authentication(memberDto.getUserId(),memberDto.getPw());
        if(loginMember == null){
            return "member/loginMemberForm";
        }

        return "index";
    }


}
