package huce.edu.vn.campain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Option Id")
    private Option optionToVote;

    @ManyToOne
    @JoinColumn(name = "Attend Id")
    private Attend attendToVote;

    @Column(name = "Value")
    private String value;
}
