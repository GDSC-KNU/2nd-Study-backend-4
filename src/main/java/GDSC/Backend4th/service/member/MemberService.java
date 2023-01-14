package GDSC.Backend4th.service.member;

import GDSC.Backend4th.Repository.MemberRepository;
import GDSC.Backend4th.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
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
