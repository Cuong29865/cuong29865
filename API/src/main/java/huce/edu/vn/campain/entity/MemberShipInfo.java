package huce.edu.vn.campain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "membershipinfo")
public class MemberShipInfo {
    @Id
    @ManyToOne
    @JoinColumn(name = "User ID")
    private User userToMemberShipInfo;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Avatar")
    private String avatar;

    @Column(name = "Organization")
    private String organization;
}
