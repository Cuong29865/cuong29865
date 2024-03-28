package huce.edu.vn.campain.service;

import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.entityConnect.CampainMore;
import huce.edu.vn.campain.repository.CampainRepository;
import huce.edu.vn.campain.repository.CampainTypeRepository;
import huce.edu.vn.campain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampainService {
    @Autowired
    private CampainRepository campainRepository;
    @Autowired
    private CampainTypeRepository campainTypeRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Option> findAllOptionByCampain(int id){
        return campainRepository.findAllOptionByCampain(id);
    }

    public List<CampainMore> findCampainByTitle(int id){
        return campainRepository.findCampainByTitle(id);
    }

    public List<CampainMore> findCampainByType(String type){
        return campainRepository.findCampainByType(type);
    }

    public List<CampainMore> findCampainByStartAndEnd(String timeStart, String timeEnd){
        if(timeStart == "") timeStart = LocalDateTime.MIN.toString();
        else if(!timeStart.contains("T") && !timeStart.contains(" ")){
            timeStart += "T00:00:00";
        } else{
            timeStart = timeStart.replace(" ", "T");
        }
        if(timeEnd == "") timeEnd = "9999-12-31T23:59:59";
        else if(!timeEnd.contains("T") && !timeEnd.contains(" ")){
            timeEnd += "T00:00:00";
        } else{
            timeEnd = timeEnd.replace(" ", "T");
        }
        return campainRepository.findCampainByStartAndEnd(LocalDateTime.parse(timeStart), LocalDateTime.parse(timeEnd));
    }

    public Campain addNewCampain(String title, String description, int typeId, String start, String end, String status
            , String metadata, String result, int ownerid){
        Campain campain = new Campain();
        campain.setTitle(title);
        campain.setDescription(description);
        campain.setCampainTypeToCampain(campainTypeRepository.findFirstById(typeId));
        if(start == "") start = LocalDateTime.MIN.toString();
        else if(!start.contains("T") && !start.contains(" ")){
            start += "T00:00:00";
        } else{
            start = start.replace(" ", "T");
        }
        if(end == "") end = "9999-12-31T23:59:59";
        else if(!end.contains("T") && !end.contains(" ")){
            end += "T00:00:00";
        } else{
            end = end.replace(" ", "T");
        }
        campain.setStart(LocalDateTime.parse(start));
        campain.setEnd(LocalDateTime.parse(end));
        campain.setStatus(status);
        campain.setMetadata(metadata);
        campain.setResult(result);
        campain.setUserToCampain(userRepository.findFirstByID(ownerid));
        campainRepository.save(campain);
        return campainRepository.findFirstByOrderByIdDesc();
    }
    public Campain updateCampain(int campainId, String timeStart, String timeEnd, String title, String status, int campainTypeId, int userId){
        Campain campain = campainRepository.findFirstById(campainId);
        if(timeStart == "") timeStart = LocalDateTime.MIN.toString();
        else if(!timeStart.contains("T") && !timeStart.contains(" ")){
            timeStart += "T00:00:00";
        } else{
            timeStart = timeStart.replace(" ", "T");
        }
        if(timeEnd == "") timeEnd = "9999-12-31T23:59:59";
        else if(!timeEnd.contains("T") && !timeEnd.contains(" ")){
            timeEnd += "T00:00:00";
        } else{
            timeEnd = timeEnd.replace(" ", "T");
        }
        campain.setStart(LocalDateTime.parse(timeStart));
        campain.setEnd(LocalDateTime.parse(timeEnd));
        campain.setTitle(title);
        campain.setCampainTypeToCampain(campainTypeRepository.findFirstById(campainTypeId));
        campain.setUserToCampain(userRepository.findFirstByID(userId));
        campain.setStatus(status);
        return campainRepository.save(campain);
    }
}
