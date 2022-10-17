package repos;

import com.rm.toolkit.onetoone.model.FeedBackEntity;
import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBackEntity, Long> {

    List<FeedBackEntity> findAllByOwnerId(Long id);

    long countByOneToOneMeet(OneToOneMeetEntity oneToOneMeet);

}