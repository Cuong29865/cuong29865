package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.AddNewCampain;
import huce.edu.vn.campain.BodyRequest.UpdateCampain;
import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.entityConnect.CampainMore;
import huce.edu.vn.campain.BodyRequest.TimeCampain;
import huce.edu.vn.campain.service.CampainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campain")
public class CampainController {
    @Autowired
    private CampainService campainService;

    //Lấy tất cả lựa chọn của một chiến dịch
    @GetMapping("/getAllOptionByCampain/{id}")
    public List<Option> getAllOptionByCampain(@PathVariable int id){
        return campainService.findAllOptionByCampain(id);
    }
    //lấy thông tin một chiến dịch theo id
    @GetMapping("/findCampainById/{id}")
    public List<CampainMore> findCampainById(@PathVariable int id){
        return campainService.findCampainByTitle(id);
    }
    //Lấy thông tin các chiến dịch theo loại chiến dịch
    @GetMapping("/findCampainByType/{type}")
    public List<CampainMore> findCampainByType(@PathVariable String type){
        return campainService.findCampainByType(type);
    }

    //Tìm chiến dịch theo thời gian bắt đầu và kết thúc có thể nhập hết or không
    @PostMapping("/findCampainByStartAndEnd")
    public List<CampainMore> findCampainByStartAndEnd(@RequestBody TimeCampain timeCampain){
        return campainService.findCampainByStartAndEnd(timeCampain.getStart(), timeCampain.getEnd());
    }

    //Thêm một chiến dịch
    @PostMapping("/addNewCampain")
    public Campain addNewCampain(@RequestBody AddNewCampain addNewCampain){
        return campainService.addNewCampain(addNewCampain.getTitle(), addNewCampain.getDescription(), addNewCampain.getTypeId(), addNewCampain.getStart()
                , addNewCampain.getEnd(), addNewCampain.getStatus(), addNewCampain.getMetadata(), addNewCampain.getResult(), addNewCampain.getOwnerid());
    }
    //Cập nhập thời gian, tiêu đề, trạng thái, thể loại, người tạo
    @PutMapping("/updateCampain")
    public Campain updateCampain(@RequestBody UpdateCampain updateCampain){
        return campainService.updateCampain(updateCampain.getCampainId(), updateCampain.getTimeStart(), updateCampain.getTimeEnd(), updateCampain.getTitle(), updateCampain.getStatus(), updateCampain.getCampainTypeId(), updateCampain.getUserId());
    }
}
