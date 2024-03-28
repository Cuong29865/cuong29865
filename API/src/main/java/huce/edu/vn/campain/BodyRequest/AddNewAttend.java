package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewAttend {
    private int campainId;
    private int userId;

    public AddNewAttend(){}
    public AddNewAttend(int campainId, int userId){
        this.campainId = campainId;
        this.userId = userId;
    }
}
