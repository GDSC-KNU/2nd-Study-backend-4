package GDSC.Backend4th.Repository;

import GDSC.Backend4th.domain.calander.Calander;
import GDSC.Backend4th.domain.calander.Daylander;
import GDSC.Backend4th.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaylanderRepository extends JpaRepository<Daylander,Long> {


//    Daylander findByCalanderAndMonthAndDay(Calander calander,Integer Month,Integer Day);
    Daylander findByCalanderAndId(Calander calander,Long id);
}
