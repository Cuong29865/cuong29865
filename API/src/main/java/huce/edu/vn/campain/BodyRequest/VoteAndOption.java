package huce.edu.vn.campain.BodyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteAndOption {
    private int voteId;
    private int optionId;

    public VoteAndOption(){}
    public VoteAndOption(int voteId, int optionId){
        this.voteId = voteId;
        this.optionId = optionId;
    }
}
