package GDSC.Backend4th.domain.calander;


import GDSC.Backend4th.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calander {


    @Id
    @GeneratedValue
    @Column(name="CALANDER_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "calander",cascade = CascadeType.ALL)
    private List<Daylander> daylanderList=new ArrayList<>();


    public Calander(List<Daylander> daylanderList) {
        this.daylanderList=daylanderList;
    }


}
