package huce.edu.vn.campain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "selection")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Campain Id")
    private Campain campainToOption;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image")
    private String image;

    @Column(name = "Title")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "optionToVote", cascade = CascadeType.ALL)
    private List<Vote> votesFromOption;
}
