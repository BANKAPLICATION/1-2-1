package oneToOne.services;

import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;

public interface OneToOneMeetService {

    ResponseOneToOne create(RequestOneToOne requestOneToOne);

}
