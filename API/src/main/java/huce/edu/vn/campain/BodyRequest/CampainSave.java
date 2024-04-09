package huce.edu.vn.campain.BodyRequest;

import huce.edu.vn.campain.entity.CampainType;
import huce.edu.vn.campain.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CampainSave {
    private String title;
    private String description;
    private int campainTypeId;
    private String start;
    private String end;
    private String status;
    private String metadata;
    private String result;
    private int userId;
}
