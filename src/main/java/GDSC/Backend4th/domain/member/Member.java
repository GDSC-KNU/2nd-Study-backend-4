package GDSC.Backend4th.domain.member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name ="userId")
    private String userId;
    private String pw;
    private String name;

    @Builder
    public Member(String userId, String pw, String name){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
    }

    public void memberUpdate(String userId, String pw){
        this.userId = userId;
        this.pw = pw;
    }
}
