package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.AttendIdAndSelectionId;
import huce.edu.vn.campain.BodyRequest.VoteAndOption;
import huce.edu.vn.campain.entity.Vote;
import huce.edu.vn.campain.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    //Lấy tất cả các user chọn một lựa chọn nào đó trong một chiến dịch
    @GetMapping("/getAllVoteForUserIntoOneCampain/{userId}/{campainId}")
    public List<Vote> getAllVoteForUserIntoOneCampain(@PathVariable int userId, @PathVariable int campainId){
        return voteService.getAllVoteForUserIntoOneCampain(userId, campainId);
    }

    //Thêm mới một lựa chọn của một user
    @PostMapping("/addNewVote")
    public Vote addNewVote(@RequestBody AttendIdAndSelectionId attendIdAndSelectionId){
        return voteService.addNewVote(attendIdAndSelectionId.getAttend(), attendIdAndSelectionId.getSelection());
    }

    //Cập nhập lựa chọn của một user(chọn cái khác)
    @PutMapping("/updateVoteForUserIntoOneCampain")
    public Vote updateVoteForUserIntoOneCampain(@RequestBody VoteAndOption voteAndOption){
        return voteService.updateVoteForUserIntoOneCampain(voteAndOption.getVoteId(), voteAndOption.getOptionId());
    }

    //Xóa lựa chọn của user
    @DeleteMapping("/deleteVote/{id}")
    public Vote deleteVoteVote(@PathVariable int id){
        return voteService.deleteVote(id);
    }
}
