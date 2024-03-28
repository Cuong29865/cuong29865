package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewCampain {
    private String title;
    private String description;
    private int typeId;
    private String start;
    private String end;
    private String status;
    private String metadata;
    private String result;
    private int ownerid;

    public AddNewCampain(){}
    public AddNewCampain(String title, String description, int typeId, String start, String end, String status
            , String metadata, String result, int ownerid){
        this.title = title;
        this.description = description;
        this.typeId = typeId;
        this.start = start;
        this.end = end;
        this.status = status;
        this.metadata = metadata;
        this.result = result;
        this.ownerid = ownerid;
    }
}
