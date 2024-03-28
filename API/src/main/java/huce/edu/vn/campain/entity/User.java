package huce.edu.vn.campain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int ID;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Display Name")
    private String displayName;

    @Column(name = "Date Create")
    private LocalDateTime dateCreate;

    @Column(name = "Date Modified")
    private LocalDateTime dateModified;

    @Column(name = "Status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "userToMemberShipInfo", cascade = CascadeType.ALL)
    private List<MemberShipInfo> memberShipInfosFromUser;

    @JsonIgnore
    @OneToMany(mappedBy = "userToCampain", cascade = CascadeType.ALL)
    private List<Campain> campainsFromUser;

    @JsonIgnore
    @OneToMany(mappedBy = "userToAttend", cascade = CascadeType.ALL)
    private List<Attend> attendsFromUser;
}
