package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampainAndSelection {
    private String campain;
    private String selection;

    public CampainAndSelection(){}

    public CampainAndSelection(String campain, String selection){
        this.campain = campain;
        this.selection = selection;
    }
}
