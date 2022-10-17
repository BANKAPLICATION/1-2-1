package services;

import com.rm.toolkit.onetoone.dtos.RequestOneToOne;
import com.rm.toolkit.onetoone.dtos.ResponseOneToOne;
import com.rm.toolkit.onetoone.dtos.Statistics;
import com.rm.toolkit.onetoone.model.Status;

import java.util.List;

public interface OneToOneMeetService {
    void delete(Long id);

    ResponseOneToOne create(RequestOneToOne requestOneToOne);

    Statistics getStatistics(Long userId);

    void setStatus(long id, Status status);

    List<ResponseOneToOne> getOneToOnePageByOwnerId(int page, int count, Status status, Long userId);

    List<ResponseOneToOne> getOneToOnePageByCreatorId(int page, int count, Status status, Long userId);
}