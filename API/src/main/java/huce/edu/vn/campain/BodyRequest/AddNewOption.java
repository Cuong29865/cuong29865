package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewOption {
    private int id;
    private String description;
    private String image;
    private String title;

    public AddNewOption(){}
    public AddNewOption(int id, String description, String image, String title){
        this.id = id;
        this.description = description;
        this.image = image;
        this.title = title;
    }
}
