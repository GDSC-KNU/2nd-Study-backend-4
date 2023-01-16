package GDSC.Backend4th.controller;

import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.dto.MemberDto;
import GDSC.Backend4th.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("memberDto") MemberDto member){
        return "member/joinMemberForm";
    }

    @PostMapping("/join")
    public String saveMember(@Valid @ModelAttribute("memberDto")MemberDto memberDto, BindingResult result){
        if(result.hasErrors()){
            return "member/joinMemberForm";
        }
        memberService.join(memberDto);
        return "redirect:/";
    }

}
