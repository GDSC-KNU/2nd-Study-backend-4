package GDSC.Backend4th.dto;

import GDSC.Backend4th.domain.member.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MemberDto {
    @NotBlank(message = "아이디를 입력하세요.")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String pw;
    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    public MemberDto(Member member){
        userId = member.getUserId();
        pw = member.getPw();
        name = member.getName();
    }

    @Builder
    public MemberDto(String userId, String pw, String name){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
    }

    public Member toEntity(){
        Member member = Member.builder()
                .name(name)
                .userId(userId)
                .pw(pw).build();
        return member;
    }
}
