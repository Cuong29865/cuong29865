package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.AddNewAttend;
import huce.edu.vn.campain.BodyRequest.AttendSave;
import huce.edu.vn.campain.entity.Attend;
import huce.edu.vn.campain.entityConnect.AttendMore;
import huce.edu.vn.campain.BodyRequest.UserSearch;
import huce.edu.vn.campain.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attend")
public class AttendController {
    @Autowired
    private AttendService attendService;

    //Đưa ra tất cả thông tin bình chọn
    @GetMapping("/allAttend")
    public List<AttendMore> getAllAttend(){
        return attendService.findAllAttend();
    }
    //Đưa ra thông tin bình chọn của một chiến dịch
    @GetMapping("/findAllAttendByOneCampain/{id}")
    public List<AttendMore> findAllAttendByOneCampain(@PathVariable int id){
        return attendService.findAllAttendByOneCampain(id);
    }
    //kiểm tra theo lựa chọn của một chiến dịch
    @GetMapping("/getAllAttendByCampainAndSelection/{campain}/{selection}")
    public List<AttendMore> getAllAttendByCampainAndSelection(@PathVariable String campain, @PathVariable String selection){
        return attendService.findAllAttendByCampainAndSelect(campain, selection);
    }
    //Lấy số lượng chọn của một lựa chọn trong một chiến dịch
    @GetMapping("/findCountAllAttendByCampainAndSelect/{campain}/{selection}")
    public int findCountAllAttendByCampainAndSelect(@PathVariable String campain, @PathVariable String selection){
        return attendService.findCountAllAttendByCampainAndSelect(campain, selection);
    }



    //Kiểm tra theo người vote
    @PostMapping("/allAttendByUserEmail")
    public List<AttendMore> getAllAttendByUserEmail(@RequestBody UserSearch userSearch){
        return attendService.findAllAttendByUserEmail(userSearch.getRequest());
    }
    @PostMapping("/allAttendByUserPhone")
    public List<AttendMore> getAllAttendByUserPhone(@RequestBody UserSearch userSearch){
        return attendService.findAllAttendByUserPhone(userSearch.getRequest());
    }

    //Thêm mới attend
    @PostMapping("/addNewAttend")
    public Attend addNewAttend(@RequestBody AddNewAttend addNewAttend){
        return attendService.addNewAttend(addNewAttend.getCampainId(), addNewAttend.getUserId());
    }



    //Api từng bảng
    @GetMapping("/getAllTableAttend")
    public List<Attend> getAllTableAttend(){
        return attendService.getAllAttend();
    }

    @PostMapping("/addAttend")
    public Attend addAttend(@RequestBody AttendSave attendSave){
        return attendService.addAttend(attendSave);
    }
    @GetMapping("/deleteAttend/{attendId}")
    public Attend deleteAttend(@PathVariable int attendId){
        return attendService.deleteAttend(attendId);
    }
    @PutMapping("/updateAttend/{attendId}")
    public Attend updateAttend(@PathVariable int attendId, @RequestBody AttendSave attendSave){
        return attendService.updateAttend(attendId, attendSave);
    }
}
