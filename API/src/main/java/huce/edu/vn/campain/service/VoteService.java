package huce.edu.vn.campain.service;

import huce.edu.vn.campain.entity.Attend;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.entity.Vote;
import huce.edu.vn.campain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AttendRepository attendRepository;
    @Autowired
    private OptionRepository optionRepository;

    public Vote addNewVote(int user, int selection){
        Vote vote = new Vote();
        vote.setAttendToVote(attendRepository.findFirstById(user));
        vote.setOptionToVote(optionRepository.findFirstById(selection));
        vote.setValue(optionRepository.findFirstById(selection).getTitle());
        voteRepository.save(vote);
        return voteRepository.findFirstByOrderByIdDesc();
    }

    public Vote deleteVote(int voteId){
        Vote vote = voteRepository.findFirstById(voteId);
        voteRepository.deleteById(voteId);
        return vote;
    }

    public List<Vote> getAllVoteForUserIntoOneCampain(int userId, int campainId){
        return attendRepository.findVoteByAttend(userId, campainId);
    }

    public Vote updateVoteForUserIntoOneCampain(int voteId, int optionId){
        Vote vote = voteRepository.findFirstById(voteId);
        vote.setValue(optionRepository.findFirstById(optionId).getTitle());
        vote.setOptionToVote(optionRepository.findFirstById(optionId));
        return voteRepository.save(vote);
    }
}
