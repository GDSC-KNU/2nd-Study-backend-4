package GDSC.Backend4th.controller.member;

import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.domain.member.SessionConst;
import GDSC.Backend4th.dto.MemberDto;
import GDSC.Backend4th.service.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public String login(@Valid @ModelAttribute MemberDto memberDto, BindingResult result, HttpServletRequest request){
        Member loginMember = memberService.authentication(memberDto.getUserId(),memberDto.getPw());
        if(loginMember == null){
            result.reject("loginFail", "아이디 또는 비밀번호를 확인하세요.");
            return "member/loginMemberForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }


}
