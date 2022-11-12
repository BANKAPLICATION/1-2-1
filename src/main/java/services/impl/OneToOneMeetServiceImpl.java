package services.impl;

import com.rm.toolkit.onetoone.dtos.RequestOneToOne;
import com.rm.toolkit.onetoone.dtos.ResponseOneToOne;
import com.rm.toolkit.onetoone.dtos.Statistics;
import com.rm.toolkit.onetoone.mappers.OneToOneMeetToEntityMapper;
import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import com.rm.toolkit.onetoone.model.Status;
import com.rm.toolkit.onetoone.repos.OneToOneMeetRepository;
import com.rm.toolkit.onetoone.services.OneToOneMeetService;
import com.rm.toolkit.onetoone.services.UserService;
import com.rm.toolkit.onetoone.services.exceptions.OneToOneException;
import com.rm.toolkit.onetoone.services.exceptions.StatusException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.rm.toolkit.onetoone.model.Status.COMPLETED;

@Service
@RequiredArgsConstructor
public class OneToOneMeetServiceImpl implements OneToOneMeetService {

    private final OneToOneMeetRepository oneToOneMeetRepository;
    private final OneToOneMeetToEntityMapper oneToOneMeetToEntityMapper;
    private final UserService userService;

    public List<OneToOneMeetEntity> findAll() {
        return oneToOneMeetRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        OneToOneMeetEntity oneToOne = findById(id);
        oneToOneMeetRepository.delete(oneToOne);
    }

    @Transactional
    public ResponseOneToOne create(RequestOneToOne requestOneToOne) {
        int countOneToOneByRM = oneToOneMeetRepository
                .countOneToOneMeetEntityByCreatorIdAndDateTime(
                        requestOneToOne.getCreatorId(),
                        requestOneToOne.getDateTime());

        if (requestOneToOne.getCreatorId().equals(requestOneToOne.getOwnerId())) {
            throw new OneToOneException("Person with id " + requestOneToOne.getCreatorId()
                    + " can't create one-to-one meet to himself");
        }

        if (requestOneToOne.getDateTime().isBefore(LocalDateTime.now())) {
            throw new OneToOneException("You can't schedule a one-to-one on the past date");
        }

        if (countOneToOneByRM >= 1) {
            throw new OneToOneException("You cannot plan several one-to-ones on the same time for one RM");
        }

        OneToOneMeetEntity oneToOneMeetEntity = oneToOneMeetToEntityMapper
                .toEntity(requestOneToOne);
        oneToOneMeetEntity.setStatus(Status.PLANNED);

        return oneToOneMeetToEntityMapper.toDto(oneToOneMeetRepository.save(oneToOneMeetEntity));
    }

    @Transactional
    public Statistics getStatistics(Long userId) {
        Long countOfSubordinates = userService.getCountOfUsersByRM(userId); // количество прямых подопечных

        if (countOfSubordinates == 0) {
            throw new OneToOneException("Employee with id " + userId + " does not have one-to-one assigned");
        }

        double avgGradeOneToOneFeedback = 0; // реализация возможна только после EP-5
        double avgGradeFeedback = 0;         // реализация возможна только после EP-6

        Date date = new Date();
        int completedOneToOne = oneToOneMeetRepository.countOneToOneInPastDate(date, userId);

        int countOfOneToOneFeedback = 0; // реализация возможна только после EP-5
        int countOfFeedback = 0; // реализация возможна только после EP-6

        return new Statistics(userId, countOfSubordinates, avgGradeOneToOneFeedback, avgGradeFeedback,
                completedOneToOne, countOfOneToOneFeedback, countOfFeedback);
    }

    @Transactional
    public void setStatus(long id, Status status) {
        OneToOneMeetEntity existContact = findById(id);
        if (existContact.getStatus() == COMPLETED) {
            throw new StatusException(HttpStatus.BAD_REQUEST, "Status cannot be changed after Completed");
        }
        existContact.setStatus(status);
        oneToOneMeetRepository.save(existContact);
    }

    private OneToOneMeetEntity findById(Long id) {
        return oneToOneMeetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No oneToOne found with id: " + id));
    }

    public List<ResponseOneToOne> getOneToOnePageByOwnerId(
            int page, int count, Status status, Long userId) {
        List<OneToOneMeetEntity>
                meetings = oneToOneMeetRepository.findAllByOwnerIdAndStatus(userId, status, PageRequest.of(page, count));
        return mapEntityToResponseOneToOne(meetings);
    }

    public List<ResponseOneToOne> getOneToOnePageByCreatorId(
            int page, int count, Status status, Long userId) {
        List<OneToOneMeetEntity>
                meetings = oneToOneMeetRepository.findAllByCreatorIdAndStatus(userId, status, PageRequest.of(page, count));
        return mapEntityToResponseOneToOne(meetings);
    }

    private List<ResponseOneToOne> mapEntityToResponseOneToOne(List<OneToOneMeetEntity> meetings) {
        return meetings.stream()
                .map(oneToOneMeetToEntityMapper::toDto)
                .collect(Collectors.toList());
    }

}