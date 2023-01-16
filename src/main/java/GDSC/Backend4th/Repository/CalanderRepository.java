package GDSC.Backend4th.Repository;

import GDSC.Backend4th.domain.calander.Calander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalanderRepository extends JpaRepository<Calander,Long> {


}
