package services.impl;


import com.rm.toolkit.onetoone.dtos.RequestFeedBack;
import com.rm.toolkit.onetoone.dtos.ResponseFeedBack;
import com.rm.toolkit.onetoone.mappers.FeedBackToEntityMapper;
import com.rm.toolkit.onetoone.model.FeedBackEntity;
import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import com.rm.toolkit.onetoone.model.Status;
import com.rm.toolkit.onetoone.repos.FeedBackRepository;
import com.rm.toolkit.onetoone.repos.OneToOneMeetRepository;
import com.rm.toolkit.onetoone.services.FeedBackService;
import com.rm.toolkit.onetoone.services.exceptions.FeedBackException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository feedBackRepository;

    private final OneToOneMeetRepository oneToOneMeetRepository;

    private final FeedBackToEntityMapper feedbackToEntityMapper;

    @Override
    @Transactional
    public ResponseFeedBack create(RequestFeedBack requestFeedBack) {
        FeedBackEntity feedbackEntity = feedbackToEntityMapper.toEntity(requestFeedBack);
        OneToOneMeetEntity oneToOneMeet = oneToOneMeetRepository.findById(feedbackEntity.getOneToOneMeet().getId())
                .orElseThrow(() -> new EntityNotFoundException("No one to one connected with feedback was found"));

        if (oneToOneMeet.getStatus() != Status.COMPLETED) {
            throw new FeedBackException(HttpStatus.BAD_REQUEST, "Feedback should be left on one to one in status COMPLETED");
        }
        if (feedBackRepository.countByOneToOneMeet(feedbackEntity.getOneToOneMeet()) > 0) {
            throw new FeedBackException(HttpStatus.BAD_REQUEST, "Only one feedback should be left on one to one");
        }
        return feedbackToEntityMapper.toDto(feedBackRepository.save(feedbackEntity));

    }

    @Override
    @Transactional
    public ResponseFeedBack edit(Long id, RequestFeedBack requestFeedBack) {
        FeedBackEntity feedBack = findById(id);
        feedbackToEntityMapper.updateFeedback(feedBack, requestFeedBack);
        return feedbackToEntityMapper.toDto(feedBackRepository.save(feedBack));

    }

    public List<ResponseFeedBack> findFeedbacksByOwnerId(Long ownerId) {
        List<FeedBackEntity> feedBackEntities = feedBackRepository.findAllByOwnerId(ownerId);
        List<ResponseFeedBack> responseFeedBacks = feedBackEntities
                .stream()
                .map(x -> feedbackToEntityMapper.toDto(x))
                .collect(Collectors.toList());
        return responseFeedBacks;

    }


    private FeedBackEntity findById(Long id) {
        return feedBackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Feedback found by id = " + id));
    }


}
