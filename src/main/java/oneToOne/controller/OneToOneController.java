package oneToOne.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;
import oneToOne.services.OneToOneMeetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one-to-one")
@RequiredArgsConstructor
public class OneToOneController {
    private final OneToOneMeetService oneToOneMeetService;
    @Operation(
            summary = "Create one to one"
    )
    @PostMapping()
    public ResponseEntity<ResponseOneToOne> createOneToOne(@RequestBody RequestOneToOne requestOneToOne) {
        return ResponseEntity.status(HttpStatus.CREATED).body(oneToOneMeetService.create(requestOneToOne));
    }
}
