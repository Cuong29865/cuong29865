package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.CampainSave;
import huce.edu.vn.campain.BodyRequest.MemberShipInfoSave;
import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.MemberShipInfo;
import huce.edu.vn.campain.service.MemberShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberShipInfo")
public class MemberShipInfoController {
    @Autowired
    private MemberShipInfoService memberShipInfoService;

    //Api từng bảng
    @GetMapping("/getAllMemberShipInfo")
    public List<MemberShipInfo> getAllMemberShipInfo(){
        return memberShipInfoService.getAllMemberShipInfo();
    }

    @PostMapping("/addMemberShipInfo")
    public MemberShipInfo addMemberShipInfo(@RequestBody MemberShipInfoSave memberShipInfoSave){
        return memberShipInfoService.addMemberShipInfo(memberShipInfoSave);
    }
    @GetMapping("/deleteMemberShipInfo/{campainId}")
    public MemberShipInfo deleteMemberShipInfo(@PathVariable int campainId){
        return memberShipInfoService.deleteMemberShipInfo(campainId);
    }
    @PutMapping("/updateMemberShipInfo")
    public MemberShipInfo updateMemberShipInfo(@RequestBody MemberShipInfoSave memberShipInfoSave){
        return memberShipInfoService.updateMemberShipInfo(memberShipInfoSave);
    }
}
