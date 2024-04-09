package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.CampainSave;
import huce.edu.vn.campain.BodyRequest.CampainTypeSave;
import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.CampainType;
import huce.edu.vn.campain.service.CampainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campainType")
public class CampainTypeController {
    @Autowired
    private CampainTypeService campainTypeService;

    //Api từng bảng
    @GetMapping("/getAllCampainType")
    public List<CampainType> getAllCampainType(){
        return campainTypeService.getAllCampainType();
    }

    @PostMapping("/addCampainType")
    public CampainType addCampainType(@RequestBody CampainTypeSave campainTypeSave){
        return campainTypeService.addCampainType(campainTypeSave);
    }
    @GetMapping("/deleteCampainType/{campainTypeId}")
    public CampainType deleteCampainType(@PathVariable int campainTypeId){
        return campainTypeService.deleteCampainType(campainTypeId);
    }
    @PutMapping("/updateCampainType/{campainTypeId}")
    public CampainType updateCampainType(@PathVariable int campainTypeId, @RequestBody CampainTypeSave campainTypeSave){
        return campainTypeService.updateCampainType(campainTypeId, campainTypeSave);
    }
}
