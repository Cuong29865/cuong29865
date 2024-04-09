package huce.edu.vn.campain.controller;

import huce.edu.vn.campain.BodyRequest.CampainSave;
import huce.edu.vn.campain.BodyRequest.UserSave;
import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.User;
import huce.edu.vn.campain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //Api từng bảng
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserSave userSave){
        return userService.addUser(userSave);
    }
    @GetMapping("/deleteUser/{userId}")
    public User deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody UserSave userSave){
        return userService.updateUser(userId, userSave);
    }
}
