package oneToOne.services.impl;

import lombok.RequiredArgsConstructor;
import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;
import oneToOne.mapper.OneToOneMeetToEntityMapper;
import oneToOne.repository.OneToOneMeetRepository;
import oneToOne.services.OneToOneMeetService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OneToOneMeetServiceImpl implements OneToOneMeetService {

    private final OneToOneMeetToEntityMapper oneToOneMeetToEntityMapper;
    private final OneToOneMeetRepository oneToOneMeetRepository;

    @Override
    public ResponseOneToOne create(RequestOneToOne requestOneToOne) {
        return oneToOneMeetToEntityMapper.toDto(oneToOneMeetRepository.save(oneToOneMeetToEntityMapper.toEntity(requestOneToOne)));
    }
}
