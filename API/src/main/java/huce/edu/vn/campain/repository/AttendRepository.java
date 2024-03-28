package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.Attend;
import huce.edu.vn.campain.entity.Vote;
import huce.edu.vn.campain.entityConnect.AttendMore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Integer> {
    @Query("select  new huce.edu.vn.campain.entityConnect.AttendMore(attend.timeStamp, attend.status, userOption.email, memberShipInfoOption.phone" +
            ", memberShipInfoOption.address, memberShipInfoOption.avatar, memberShipInfoOption.organization, userOrganization.email, memberShipInfoOrganization.phone" +
            ", memberShipInfoOrganization.address, memberShipInfoOrganization.avatar, memberShipInfoOrganization.organization, campain.title, option.title) " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id")
    public List<AttendMore> findAllAttend();

    @Query("select  new huce.edu.vn.campain.entityConnect.AttendMore(attend.timeStamp, attend.status, userOption.email, memberShipInfoOption.phone" +
            ", memberShipInfoOption.address, memberShipInfoOption.avatar, memberShipInfoOption.organization, userOrganization.email, memberShipInfoOrganization.phone" +
            ", memberShipInfoOrganization.address, memberShipInfoOrganization.avatar, memberShipInfoOrganization.organization, campain.title, option.title) " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id " +
            "where campain.id = :id")
    public List<AttendMore> findAllAttendByOneCampain(@Param("id") int id);

    @Query("select  new huce.edu.vn.campain.entityConnect.AttendMore(attend.timeStamp, attend.status, userOption.email, memberShipInfoOption.phone" +
            ", memberShipInfoOption.address, memberShipInfoOption.avatar, memberShipInfoOption.organization, userOrganization.email, memberShipInfoOrganization.phone" +
            ", memberShipInfoOrganization.address, memberShipInfoOrganization.avatar, memberShipInfoOrganization.organization, campain.title, option.title) " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id " +
            "where userOption.email = :email")
    public List<AttendMore> findAllAttendByUserEmail(@Param("email") String email);

    @Query("select  new huce.edu.vn.campain.entityConnect.AttendMore(attend.timeStamp, attend.status, userOption.email, memberShipInfoOption.phone" +
            ", memberShipInfoOption.address, memberShipInfoOption.avatar, memberShipInfoOption.organization, userOrganization.email, memberShipInfoOrganization.phone" +
            ", memberShipInfoOrganization.address, memberShipInfoOrganization.avatar, memberShipInfoOrganization.organization, campain.title, option.title) " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id " +
            "where memberShipInfoOption.phone = :phone")
    public List<AttendMore> findAllAttendByUserPhone(@Param("phone") String phone);

    @Query("select  new huce.edu.vn.campain.entityConnect.AttendMore(attend.timeStamp, attend.status, userOption.email, memberShipInfoOption.phone" +
            ", memberShipInfoOption.address, memberShipInfoOption.avatar, memberShipInfoOption.organization, userOrganization.email, memberShipInfoOrganization.phone" +
            ", memberShipInfoOrganization.address, memberShipInfoOrganization.avatar, memberShipInfoOrganization.organization, campain.title, option.title) " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id " +
            "where campain.title = :campainTitle and option.title = :optionTitle")
    public List<AttendMore> findAllAttendByCampainAndSelect(@Param("campainTitle") String campainTitle, @Param("optionTitle") String optionTitle);

    @Query("select attend.id " +
            "from Attend attend inner join attend.userToAttend userOption on attend.userToAttend.ID = userOption.ID " +
            "inner join userOption.memberShipInfosFromUser memberShipInfoOption on userOption.ID = memberShipInfoOption.userToMemberShipInfo.ID " +
            "inner join attend.campainToAttend campain on attend.campainToAttend.id = campain.id " +
            "inner join campain.userToCampain userOrganization on campain.userToCampain.ID = userOrganization.ID " +
            "inner join userOrganization.memberShipInfosFromUser memberShipInfoOrganization on userOrganization.ID = memberShipInfoOrganization.userToMemberShipInfo.ID " +
            "inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join vote.optionToVote option on option.id = vote.optionToVote.id " +
            "where campain.title = :campainTitle and option.title = :optionTitle")
    public int findCountAllAttendByCampainAndSelect(@Param("campainTitle") String campainTitle, @Param("optionTitle") String optionTitle);

    @Query("select vote from Attend attend inner join attend.votesFromAttend vote on vote.attendToVote.id = attend.id " +
            "inner join attend.userToAttend user on user.ID = attend.userToAttend.ID " +
            "inner join attend.campainToAttend campain on campain.id = attend.campainToAttend.id " +
            "where user.ID = :userId and campain.id = :campainId")
    public List<Vote> findVoteByAttend(@Param("userId") int userId, @Param("campainId") int campainId);

    public Attend findFirstById(int id);
}
