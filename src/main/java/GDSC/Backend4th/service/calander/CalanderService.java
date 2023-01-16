package GDSC.Backend4th.service.calander;

import GDSC.Backend4th.Repository.CalanderRepository;
import GDSC.Backend4th.Repository.DaylanderRepository;
import GDSC.Backend4th.domain.calander.Calander;
import GDSC.Backend4th.domain.calander.Daylander;
import GDSC.Backend4th.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalanderService {

    private final CalanderRepository calanderRepository;
    private final DaylanderRepository daylanderRepository;



    public void make_calander(Member member) {
        Calander findCalander = member.getCalander();

        if(findCalander==null) {

            Calander calander=new Calander();
            calanderRepository.save(calander);
        }
    }
    public void register_day(Member member,Daylander daylander) {

        save_day(member,daylander);
    }

    public void save_day(Member member,Daylander daylander) {

        Calander calander = member.getCalander();
        List<Daylander> daylanderList = calander.getDaylanderList();
        daylanderList.add(daylander);
        daylander.setCalander(calander);
        daylanderRepository.save(daylander);
    }

//    public void delete_day(Member member,Daylander daylander) {
//        Daylander findDay = daylanderRepository.findByCalanderAndMonthAndDay(daylander.getCalander(), daylander.getMonth(), daylander.getDay());
//        daylanderRepository.delete(findDay);
//    }

    public void edit_day(Member member,Daylander curr,Daylander next) {
        Calander findCalander = member.getCalander();
        Daylander currDay = daylanderRepository.findByCalanderAndId(findCalander,curr.getId());

        currDay.edit_currDay(next.getMonth(), next.getDay(), next.getYear(), next.getDescription(), LocalDateTime.now());
    }

}
