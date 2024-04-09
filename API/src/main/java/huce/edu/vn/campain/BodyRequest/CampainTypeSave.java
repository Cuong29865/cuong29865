package huce.edu.vn.campain.BodyRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import huce.edu.vn.campain.entity.Campain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CampainTypeSave {
    private String description;
    private String fieldType;
    public CampainTypeSave(){}
    public CampainTypeSave(String description, String fieldType){
        this.description = description;
        this.fieldType = fieldType;
    }
}
