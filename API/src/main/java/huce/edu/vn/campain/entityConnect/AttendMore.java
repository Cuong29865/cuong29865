package huce.edu.vn.campain.entityConnect;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendMore {
    private LocalDateTime attendTimeStamp;
    private String attendStatus;

    private String userOptionEmail;
    private String userOptionPhone;
    private String userOptionAddress;
    private String userOptionAvatar;
    private String userOptionOrganization;


    private String userOrganizationEmail;
    private String userOrganizationPhone;
    private String userOrganizationAddress;
    private String userOrganizationAvatar;
    private String userOrganization;

    private String campainTitle;
    private String optionTitle;
    public AttendMore(LocalDateTime attendTimeStamp, String attendStatus, String userOptionEmail, String userOptionPhone, String userOptionAddress,
                      String userOptionAvatar, String userOptionOrganization, String userOrganizationEmail, String userOrganizationPhone, String userOrganizationAddress,
                      String userOrganizationAvatar, String userOrganization, String campainTitle, String optionTitle){
        this.attendTimeStamp = attendTimeStamp;
        this.attendStatus = attendStatus;

        this.userOptionEmail = userOptionEmail;
        this.userOptionPhone = userOptionPhone;
        this.userOptionAddress = userOptionAddress;
        this.userOptionAvatar = userOptionAvatar;
        this.userOptionOrganization = userOptionOrganization;

        this.userOrganizationEmail = userOrganizationEmail;
        this.userOrganizationPhone = userOrganizationPhone;
        this.userOrganizationAddress = userOrganizationAddress;
        this.userOrganizationAvatar = userOrganizationAvatar;
        this.userOrganization = userOrganization;

        this.campainTitle = campainTitle;
        this.optionTitle = optionTitle;
    }
}
