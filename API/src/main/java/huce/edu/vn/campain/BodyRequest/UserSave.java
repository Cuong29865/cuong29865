package huce.edu.vn.campain.BodyRequest;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSave {
    private String email;
    private String password;
    private String displayName;
    private String dateCreate;
    private String dateModified;
    private String status;
}
