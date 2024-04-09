package huce.edu.vn.campain.service;

import huce.edu.vn.campain.BodyRequest.UserSave;
import huce.edu.vn.campain.entity.User;
import huce.edu.vn.campain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User deleteUser(int id){
        User user = userRepository.findFirstByID(id);
        userRepository.delete(user);
        return user;
    }

    public  User addUser(UserSave userSave){
        User user = new User();
        user.setEmail(userSave.getEmail());
        user.setPassword(userSave.getPassword());
        user.setDisplayName(userSave.getDisplayName());
        if(userSave.getDateCreate() == "") userSave.setDateCreate(LocalDateTime.MIN.toString());
        else if(!userSave.getDateCreate().contains("T") && !userSave.getDateCreate().contains(" ")){
            userSave.setDateCreate(userSave.getDateCreate() +"T00:00:00");
        } else{
            userSave.setDateCreate(userSave.getDateCreate().replace(" ", "T"));
        }
        if(userSave.getDateModified() == "") userSave.setDateModified(LocalDateTime.MIN.toString());
        else if(!userSave.getDateModified().contains("T") && !userSave.getDateModified().contains(" ")){
            userSave.setDateModified(userSave.getDateModified() +"T00:00:00");
        } else{
            userSave.setDateModified(userSave.getDateModified().replace(" ", "T"));
        }
        user.setDateCreate(LocalDateTime.parse(userSave.getDateCreate()));
        user.setDateModified(LocalDateTime.parse(userSave.getDateModified()));
        user.setStatus(userSave.getStatus());
        return userRepository.save(user);
    }

    public User updateUser(int id, UserSave userSave){
        User user = userRepository.findFirstByID(id);
        user.setEmail(userSave.getEmail());
        user.setPassword(userSave.getPassword());
        user.setDisplayName(userSave.getDisplayName());
        if(userSave.getDateCreate() == "") userSave.setDateCreate(LocalDateTime.MIN.toString());
        else if(!userSave.getDateCreate().contains("T") && !userSave.getDateCreate().contains(" ")){
            userSave.setDateCreate(userSave.getDateCreate() +"T00:00:00");
        } else{
            userSave.setDateCreate(userSave.getDateCreate().replace(" ", "T"));
        }
        if(userSave.getDateModified() == "") userSave.setDateModified(LocalDateTime.MIN.toString());
        else if(!userSave.getDateModified().contains("T") && !userSave.getDateModified().contains(" ")){
            userSave.setDateModified(userSave.getDateModified() +"T00:00:00");
        } else{
            userSave.setDateModified(userSave.getDateModified().replace(" ", "T"));
        }
        user.setDateModified(LocalDateTime.parse(userSave.getDateModified()));
        user.setStatus(userSave.getStatus());
        return userRepository.save(user);
    }
}
