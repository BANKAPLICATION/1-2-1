package oneToOne.repository;

import oneToOne.model.OneToOneMeetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneMeetRepository extends JpaRepository<OneToOneMeetEntity, Long> {

}
