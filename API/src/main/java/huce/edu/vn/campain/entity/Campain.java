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
@Table(name = "campain")
public class Campain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Campain Type Id")
    private CampainType campainTypeToCampain;

    @Column(name = "Start")
    private LocalDateTime start;

    @Column(name = "End")
    private LocalDateTime end;

    @Column(name = "Status")
    private String status;

    @Column(name = "Metadata")
    private String metadata;

    @Column(name = "Result")
    private String result;

    @ManyToOne
    @JoinColumn(name = "Owner Id")
    private User userToCampain;

    @JsonIgnore
    @OneToMany(mappedBy = "campainToAttend", cascade = CascadeType.ALL)
    private List<Attend> attendsFromCampain;

    @JsonIgnore
    @OneToMany(mappedBy = "campainToOption", cascade = CascadeType.ALL)
    private List<Option> optionsFromCampain;
}
