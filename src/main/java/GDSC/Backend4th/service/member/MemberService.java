package GDSC.Backend4th.service.member;

import GDSC.Backend4th.Repository.CalanderRepository;
import GDSC.Backend4th.Repository.MemberRepository;
import GDSC.Backend4th.domain.calander.Calander;
import GDSC.Backend4th.domain.calander.Daylander;
import GDSC.Backend4th.domain.member.Member;
import GDSC.Backend4th.dto.MemberDto;
import GDSC.Backend4th.service.calander.CalanderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private final CalanderService calanderService;



    @Transactional
    public Long join(MemberDto memberDto){
        Member member = memberDto.toEntity();
        validateDuplicateMember(member);
        memberRepository.save(member);
        calanderService.make_calander(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMember = memberRepository.findByUserId(member.getUserId());
        System.out.println("findMember = " + findMember);
        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다."); }
    }

    public boolean findUserIdExist(String userId){
        List<Member> findMember = memberRepository.findByUserId(userId);
        System.out.println("findMember = " + findMember);
        if(findMember.isEmpty()){
            System.out.println("사용가능");
            return true;
        }
        System.out.println("사용불가능");
        return false;
    }

    public Member authentication(String userId, String pw){
        List<Member> member = memberRepository.findByUserId(userId);
        if(member.isEmpty()){
            return null;
        }
        if(member.get(0).getPw().equals(pw)){
            return member.get(0);
        }
        return null;
    }


}
