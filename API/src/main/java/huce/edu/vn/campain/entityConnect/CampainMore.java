package huce.edu.vn.campain.entityConnect;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CampainMore {
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private String status;
    private String metadata;
    private String result;
    private String email;
    private String organization;
    private String type;

    public CampainMore(){}

    public CampainMore(String title, String description, LocalDateTime start, LocalDateTime end, String status, String metadata
            , String result, String email, String organization, String type){
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.status = status;
        this.metadata = metadata;
        this.result = result;
        this.email = email;
        this.organization = organization;
        this.type = type;
    }
}
