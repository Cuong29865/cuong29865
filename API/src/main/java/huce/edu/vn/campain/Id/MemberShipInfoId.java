package huce.edu.vn.campain.Id;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class MemberShipInfoId implements Serializable {
    private int id;
}
