package GDSC.Backend4th.controller;

import GDSC.Backend4th.domain.member.SessionConst;
import GDSC.Backend4th.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) MemberDto loginMember, Model model){
        if(loginMember == null){
            return "index";
        }

        model.addAttribute("memberDto", loginMember);
        return "home";
    }
}
