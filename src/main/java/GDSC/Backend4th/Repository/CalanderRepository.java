package GDSC.Backend4th.Repository;

import GDSC.Backend4th.domain.calander.Calander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalanderRepository extends JpaRepository<Calander,Long> {

//    Optional<Calander> findById(Long id);
}
