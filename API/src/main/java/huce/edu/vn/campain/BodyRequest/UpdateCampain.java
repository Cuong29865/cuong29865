package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCampain {
    private int campainId;
    private String timeStart;
    private String timeEnd;
    private String title;
    private String status;
    private int campainTypeId;
    private int userId;

    public UpdateCampain(){}
    public UpdateCampain(int campainId, String timeStart, String timeEnd, String title, String status, int campainTypeId, int userId){
        this.campainId = campainId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.status = status;
        this.campainTypeId = campainTypeId;
        this.userId = userId;
    }
}
