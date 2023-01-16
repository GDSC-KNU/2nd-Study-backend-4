package GDSC.Backend4th.service.calander;

import GDSC.Backend4th.Repository.CalanderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CalanderService {

    private final CalanderRepository calanderRepository;

}
