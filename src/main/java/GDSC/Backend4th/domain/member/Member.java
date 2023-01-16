package GDSC.Backend4th.domain.member;


import GDSC.Backend4th.domain.calander.Calander;
import jakarta.persistence.*;
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


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="CALANDER_ID")
    private Calander calander;

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
