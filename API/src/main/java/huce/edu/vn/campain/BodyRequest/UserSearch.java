package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearch {
    private String request;

    public UserSearch(){}

    public UserSearch(String request){
        this.request = request;
    }
}
