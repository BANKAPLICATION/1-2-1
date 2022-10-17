package controllers;

import com.rm.toolkit.onetoone.dtos.RequestFeedBack;
import com.rm.toolkit.onetoone.dtos.ResponseFeedBack;
import com.rm.toolkit.onetoone.services.FeedBackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Log
@RestController
@SecurityRequirement(name = "bearer")
@RequestMapping("/one-to-one/feedbacks")
@RequiredArgsConstructor
public class FeedBackController {

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender mailSender;

    private final FeedBackService feedBackService;

    @Operation(
            summary = "Add FeedBack"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseFeedBack addFeedback(
            @RequestBody @Valid RequestFeedBack requestFeedBack) {
        return feedBackService.create(requestFeedBack);
    }

    @Operation(
            summary = "Edit FeedBack"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseFeedBack editFeedback(
            @PathVariable("id") Long id, @RequestBody RequestFeedBack requestFeedBack) {
        return feedBackService.edit(id, requestFeedBack);
    }


    @Operation(
            summary = "View FeedBack"
    )
    @GetMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseFeedBack> findByOwnerId(
            @PathVariable("ownerId") Long ownerId) {
        return feedBackService.findFeedbacksByOwnerId(ownerId);
    }

}