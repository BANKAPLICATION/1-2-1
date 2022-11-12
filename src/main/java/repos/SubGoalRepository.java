package repos;

import com.rm.toolkit.onetoone.model.SubGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGoalRepository extends JpaRepository<SubGoalEntity, Long> {

}
