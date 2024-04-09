package huce.edu.vn.campain.service;

import huce.edu.vn.campain.BodyRequest.AttendSave;
import huce.edu.vn.campain.entity.Attend;
import huce.edu.vn.campain.entityConnect.AttendMore;
import huce.edu.vn.campain.repository.AttendRepository;
import huce.edu.vn.campain.repository.CampainRepository;
import huce.edu.vn.campain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendService {
    @Autowired
    private AttendRepository attendRepository;
    @Autowired
    private CampainRepository campainRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AttendMore> findAllAttend(){
        return attendRepository.findAllAttend();
    }

    public List<AttendMore> findAllAttendByUserEmail(String email){
        return attendRepository.findAllAttendByUserEmail(email);
    }

    public List<AttendMore> findAllAttendByUserPhone(String phone){
        return attendRepository.findAllAttendByUserPhone(phone);
    }

    public int findCountAllAttendByCampainAndSelect(String campain, String selection){
        return attendRepository.findCountAllAttendByCampainAndSelect(campain, selection);
    }

    public List<AttendMore> findAllAttendByCampainAndSelect(String campain, String selection){
        return attendRepository.findAllAttendByCampainAndSelect(campain, selection);
    }

    public List<AttendMore> findAllAttendByOneCampain(int id){
        return attendRepository.findAllAttendByOneCampain(id);
    }

    public Attend addNewAttend(int campainId, int userId){
        Attend attend = new Attend();
        attend.setCampainToAttend(campainRepository.findFirstById(campainId));
        attend.setUserToAttend(userRepository.findFirstByID(userId));
        attend.setTimeStamp(LocalDateTime.now());
        attend.setStatus("opend");
        return attendRepository.save(attend);
    }



    //Truy xuất bảng đơn
    public List<Attend> getAllAttend(){
        return attendRepository.findAll();
    }
    public Attend addAttend(AttendSave attendSave){
        Attend attend = new Attend();
        attend.setCampainToAttend(campainRepository.findFirstById(attendSave.getCampainId()));
        attend.setUserToAttend(userRepository.findFirstByID(attendSave.getUserId()));
        if(attendSave.getTimeCreat() == "") attendSave.setTimeCreat(LocalDateTime.MIN.toString());
        else if(!attendSave.getTimeCreat().contains("T") && !attendSave.getTimeCreat().contains(" ")){
            attendSave.setTimeCreat(attendSave.getTimeCreat() +"T00:00:00");
        } else{
            attendSave.setTimeCreat(attendSave.getTimeCreat().replace(" ", "T"));
        }
        attend.setTimeStamp(LocalDateTime.parse(attendSave.getTimeCreat()));
        attend.setStatus(attendSave.getStatus());
        return attendRepository.save(attend);
    }
    public Attend deleteAttend(int id){
        Attend attend = attendRepository.findFirstById(id);
        attendRepository.delete(attend);
        return attend;
    }
    public Attend updateAttend(int attendId, AttendSave attendSave){
        if(attendSave.getTimeCreat() == "") attendSave.setTimeCreat(LocalDateTime.MIN.toString());
        else if(!attendSave.getTimeCreat().contains("T") && !attendSave.getTimeCreat().contains(" ")){
            attendSave.setTimeCreat(attendSave.getTimeCreat() +"T00:00:00");
        } else{
            attendSave.setTimeCreat(attendSave.getTimeCreat().replace(" ", "T"));
        }
        Attend attend = attendRepository.findFirstById(attendId);
        attend.setCampainToAttend(campainRepository.findFirstById(attendSave.getCampainId()));
        attend.setUserToAttend(userRepository.findFirstByID(attendSave.getUserId()));
        attend.setTimeStamp(LocalDateTime.parse(attendSave.getTimeCreat()));
        attend.setStatus(attendSave.getStatus());
        return attendRepository.save(attend);
    }
}
