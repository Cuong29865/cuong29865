package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendIdAndSelectionId {
    private int attend;
    private int selection;

    public AttendIdAndSelectionId(){}
    public AttendIdAndSelectionId(int attend, int selection){
        this.attend = attend;
        this.selection = selection;
    }
}
