package GDSC.Backend4th.Repository;

import GDSC.Backend4th.domain.calander.Calander;
import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.dto.MemberDto;
import GDSC.Backend4th.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    MemberService service;
    @Test
    @Transactional
    @Rollback
    public void 달력찾기() throws Exception {
        //given
        MemberDto memberDto = new MemberDto();
        memberDto.setName("lee");
        memberDto.setPw("1234");
        memberDto.setUserId("test213322223");

        //when
        Long join = service.join(memberDto);

        //then
        Member member = service.findById(join);

        Calander byMember = service.findCalanderByMemberId(member.getUserId());
        System.out.println(byMember.getMember().getUserId());

        Assertions.assertThat(byMember.getMember()).isEqualTo(member);
    }

}