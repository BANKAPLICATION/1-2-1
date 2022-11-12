package repos;

import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import com.rm.toolkit.onetoone.model.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface OneToOneMeetRepository extends JpaRepository<OneToOneMeetEntity, Long> {

    @Query(value = "SELECT COUNT (o) FROM OneToOneMeetEntity o WHERE o.dateTime = :date and o.creatorId = :id")
    int countOneToOneMeetEntityByCreatorIdAndDateTime(@Param("id") Long id, @Param("date") LocalDateTime localDateTime);

    @Query(value = "SELECT COUNT (o) FROM OneToOneMeetEntity o WHERE o.dateTime < :date and o.creatorId = :id")
    int countOneToOneInPastDate(@Param("date") Date date, @Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE OneToOneMeetEntity SET status= :status WHERE id = :id")
    void setStatus(@Param("id") long id, @Param("status") String status);

    List<OneToOneMeetEntity> findAllByOwnerIdAndStatus(Long id, Status status, Pageable request);

    List<OneToOneMeetEntity> findAllByCreatorIdAndStatus(Long id, Status status, Pageable request);

    List<OneToOneMeetEntity> findAllByFeedBackNull();
}