package dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OneToOneEdit {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date dateTime;

    private String comment;

    private Set<Notification> notifications;
}
