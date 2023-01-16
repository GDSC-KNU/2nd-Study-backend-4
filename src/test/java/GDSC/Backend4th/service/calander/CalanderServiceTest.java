package GDSC.Backend4th.service.calander;

import GDSC.Backend4th.Repository.CalanderRepository;
import GDSC.Backend4th.Repository.MemberRepository;
import GDSC.Backend4th.domain.calander.Calander;
import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.service.member.MemberService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalanderServiceTest {


    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CalanderService calanderService;

    @Autowired
    private CalanderRepository calanderRepository;

    @Test
    public void make_calander() {
        Member member=new Member("hys33","1234","황효성");
        memberRepository.save(member);

        calanderService.make_calander(member);

    }
}