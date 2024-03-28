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
@Table(name = "attend")
public class Attend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Campain Id")
    private Campain campainToAttend;

    @ManyToOne
    @JoinColumn(name = "User Id")
    private User userToAttend;

    @Column(name = "Time Create")
    private LocalDateTime timeStamp;

    @Column(name = "Status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "attendToVote", cascade = CascadeType.ALL)
    private List<Vote> votesFromAttend;
}
