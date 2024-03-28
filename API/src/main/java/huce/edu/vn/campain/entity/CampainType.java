package huce.edu.vn.campain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "campaintype")
public class CampainType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "Field Type")
    private String fieldType;

    @JsonIgnore
    @OneToMany(mappedBy = "campainTypeToCampain", cascade = CascadeType.ALL)
    private List<Campain> campainsFromCampainType;
}
