package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendSave {
    private int campainId;
    private int userId;
    private String timeCreat;
    private String status;

    public AttendSave(){}
    public AttendSave(int campainId, int userId, String timeCreat, String status){
        this.campainId = campainId;
        this.userId = userId;
        this.timeCreat = timeCreat;
        this.status = status;
    }
}
