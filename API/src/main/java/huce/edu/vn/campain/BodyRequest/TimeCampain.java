package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeCampain {
    private String start;
    private String end;

    public TimeCampain(){}
    public TimeCampain(String start, String end){
        this.start = start;
        this.end = end;
    }
}
