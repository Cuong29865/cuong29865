package huce.edu.vn.campain.BodyRequest;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberShipInfoSave {
    private int userId;
    private String phone;
    private String address;
    private String avatar;
    private String organization;
}
