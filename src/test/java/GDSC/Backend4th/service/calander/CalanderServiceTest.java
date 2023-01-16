package GDSC.Backend4th.service.calander;

import GDSC.Backend4th.Repository.CalanderRepository;
import GDSC.Backend4th.Repository.MemberRepository;
import GDSC.Backend4th.domain.calander.Daylander;
import GDSC.Backend4th.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@RequiredArgsConstructor
public class CalanderServiceTest {




    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CalanderService calanderService;

    @Autowired
    private CalanderRepository calanderRepository;


    @Test
    public void make_calander() {
        List<Member> findMember = memberRepository.findByUserId("dahyun");

    }
}