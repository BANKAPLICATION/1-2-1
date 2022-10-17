package services;

import com.rm.toolkit.onetoone.dtos.RequestFeedBack;
import com.rm.toolkit.onetoone.dtos.ResponseFeedBack;

import java.util.List;

public interface FeedBackService {
    ResponseFeedBack create(RequestFeedBack feedback);

    ResponseFeedBack edit(Long id, RequestFeedBack requestFeedBack);

    List<ResponseFeedBack> findFeedbacksByOwnerId(Long ownerId);
}
