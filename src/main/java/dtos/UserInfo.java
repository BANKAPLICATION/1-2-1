package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private RoleInfo role;

    private Set<UserInfo> subordinates;

    private UserInfo chief;
}
