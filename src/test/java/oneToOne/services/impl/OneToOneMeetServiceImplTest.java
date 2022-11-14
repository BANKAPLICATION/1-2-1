package oneToOne.services.impl;

import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;
import oneToOne.model.Status;
import oneToOne.services.OneToOneMeetService;
import org.bouncycastle.cert.ocsp.Req;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OneToOneMeetServiceImplTest {

    @Mock
    private OneToOneMeetService oneToOneMeetService;

    @Test
    void shouldCreateOneToOne() {
        RequestOneToOne requestOneToOne = RequestOneToOne.builder()
                .comment("Java interview to Senior position")
                .ownerId(1L)
                .creatorId(2L)
                .id(1L)
                .dateTime(LocalDateTime.now())
                .status(Status.PLANNED)
                .build();
        ResponseOneToOne responseOneToOne = ResponseOneToOne.builder()
                .comment("Java interview to Senior position")
                .ownerId(1L)
                .creatorId(2L)
                .id(1L)
                .dateTime(LocalDateTime.now())
                .status(Status.PLANNED)
                .build();

        Mockito.when(oneToOneMeetService.create(requestOneToOne)).thenReturn(responseOneToOne);

        ResponseOneToOne response = oneToOneMeetService.create(requestOneToOne);

        assertEquals("Java interview to Senior position", response.getComment());
        assertEquals(1L, response.getOwnerId());
        assertEquals(2L, response.getCreatorId());
        assertEquals(1, response.getId());
        assertEquals(Status.PLANNED, response.getStatus());


    }
}