package GDSC.Backend4th.domain.member;

import GDSC.Backend4th.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DuplicatedController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/member/checkUserId/{userId}")
    public String checkUserId(@PathVariable String userId){
        System.out.println("userId = " + userId);
        boolean chk = memberService.findUserIdExist(userId);
        return chk + "";
    }
}
