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




    @OneToMany(mappedBy = "calander",cascade = CascadeType.ALL)
    private List<Daylander> daylanderList=new ArrayList<>();


    public Calander(List<Daylander> daylanderList) {
        int i,j;

        this.daylanderList=daylanderList;

        for(i=1;i<13;i++) {
            Daylander daylander;
            if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12 ) {
                for(j=1;j<32;j++) {
                    daylander=new Daylander(i,j,2023,null, LocalDateTime.now());
                    daylander.setCalander(this);
                    this.daylanderList.add(daylander);
                }
            }
            else {
                if(i==2) {

                    for(j=1;j<29;j++) {
                        daylander=new Daylander(i,j,2023,null, LocalDateTime.now());
                        daylander.setCalander(this);
                        this.daylanderList.add(daylander);
                    }

                }
                else {

                    for(j=1;j<31;j++) {
                        daylander=new Daylander(i,j,2023,null, LocalDateTime.now());
                        daylander.setCalander(this);
                        this.daylanderList.add(daylander);
                    }
                }
            }
        }
    }
}
