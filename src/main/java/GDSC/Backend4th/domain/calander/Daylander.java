package GDSC.Backend4th.domain.calander;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Daylander {


    @Id
    @GeneratedValue
    @Column(name="DAY_ID")
    private Long id;

    private Integer Month;
    private Integer Day;
    private Integer Year;

    private String description;
    private LocalDateTime localDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CALANDER_ID")
    private Calander calander;


    public Daylander(Integer Month,Integer Day,Integer Year,String Description,LocalDateTime localDateTime) {
        this.Month=Month;
        this.Day=Day;
        this.Year=Year;
        this.description=Description;
        this.localDateTime=localDateTime;
    }

}
