package GDSC.Backend4th.domain.member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @NotBlank(message = "아이디를 입력하세요.")
    @Column(name ="userId")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String pw;
    @NotBlank(message = "이름을 입력하세요.")
    private String name;
}
