package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.AddNewOption;
import huce.edu.vn.campain.BodyRequest.CampainSave;
import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/option")
public class OptionController {
    @Autowired
    private OptionService optionService;

    //Thêm mới một lựa chọn trong một chiến dịch
    @PostMapping("/addNewOption")
    public Option addNewOption(@RequestBody AddNewOption addNewOption){
        return optionService.addNewOption(addNewOption.getId(), addNewOption.getDescription(), addNewOption.getImage(), addNewOption.getTitle());
    }

    //Cập nhập một lựa chọn trong một chiến dịch
    @PutMapping("/updateOption")
    public Option updateOption(@RequestBody AddNewOption addNewOption){
        return optionService.updateOption(addNewOption.getId(), addNewOption.getDescription(), addNewOption.getImage(), addNewOption.getTitle());
    }


    //Api từng bảng
    @GetMapping("/getAllOption")
    public List<Option> getAllOption(){
        return optionService.getAllOption();
    }
    @GetMapping("/deleteOption/{optionId}")
    public Option deleteOption(@PathVariable int optionId){
        return optionService.deleteOption(optionId);
    }
}
