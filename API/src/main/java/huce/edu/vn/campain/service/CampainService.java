package huce.edu.vn.campain.service;

import huce.edu.vn.campain.BodyRequest.CampainSave;
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
import java.util.Objects;

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
        if(Objects.equals(timeStart, "")) timeStart = LocalDateTime.MIN.toString();
        else if(!timeStart.contains("T") && !timeStart.contains(" ")){
            timeStart += "T00:00:00";
        } else{
            timeStart = timeStart.replace(" ", "T");
        }
        if(Objects.equals(timeEnd, "")) timeEnd = "9999-12-31T23:59:59";
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



    //Truy xuất bảng đơn
    public List<Campain> getAllCampain(){
        return campainRepository.findAll();
    }
    public Campain addCampain(CampainSave campainSave){
        Campain campain = new Campain();
        if(campainSave.getStart() == "") campainSave.setStart(LocalDateTime.MIN.toString());
        else if(!campainSave.getStart().contains("T") && !campainSave.getStart().contains(" ")){
            campainSave.setStart(campainSave.getStart() + "T00:00:00");
        } else{
            campainSave.setStart(campainSave.getStart().replace(" ", "T"));
        }
        if(campainSave.getEnd() == "") campainSave.setEnd("9999-12-31T23:59:59");
        else if(!campainSave.getEnd().contains("T") && !campainSave.getEnd().contains(" ")){
            campainSave.setEnd(campainSave.getEnd() + "T00:00:00");
        } else{
            campainSave.setEnd(campainSave.getEnd().replace(" ", "T"));
        }
        campain.setTitle(campainSave.getTitle());
        campain.setDescription(campainSave.getDescription());
        campain.setCampainTypeToCampain(campainTypeRepository.findFirstById(campainSave.getCampainTypeId()));
        campain.setStart(LocalDateTime.parse(campainSave.getStart()));
        campain.setEnd(LocalDateTime.parse(campainSave.getEnd()));
        campain.setStatus(campainSave.getStatus());
        campain.setMetadata(campainSave.getMetadata());
        campain.setResult(campainSave.getResult());
        campain.setUserToCampain(userRepository.findFirstByID(campainSave.getUserId()));
        return campainRepository.save(campain);
    }
    public Campain deleteCampain(int id){
        Campain campain = campainRepository.findFirstById(id);
        campainRepository.delete(campain);
        return campain;
    }
    public Campain updateCampain(int campainId, CampainSave campainSave){
        Campain campain = campainRepository.findFirstById(campainId);
        if(campainSave.getStart() == "") campainSave.setStart(LocalDateTime.MIN.toString());
        else if(!campainSave.getStart().contains("T") && !campainSave.getStart().contains(" ")){
            campainSave.setStart(campainSave.getStart() + "T00:00:00");
        } else{
            campainSave.setStart(campainSave.getStart().replace(" ", "T"));
        }
        if(campainSave.getEnd() == "") campainSave.setEnd("9999-12-31T23:59:59");
        else if(!campainSave.getEnd().contains("T") && !campainSave.getEnd().contains(" ")){
            campainSave.setEnd(campainSave.getEnd() + "T00:00:00");
        } else{
            campainSave.setEnd(campainSave.getEnd().replace(" ", "T"));
        }
        campain.setTitle(campainSave.getTitle());
        campain.setDescription(campainSave.getDescription());
        campain.setCampainTypeToCampain(campainTypeRepository.findFirstById(campainSave.getCampainTypeId()));
        campain.setStart(LocalDateTime.parse(campainSave.getStart()));
        campain.setEnd(LocalDateTime.parse(campainSave.getEnd()));
        campain.setStatus(campainSave.getStatus());
        campain.setMetadata(campainSave.getMetadata());
        campain.setResult(campainSave.getResult());
        campain.setUserToCampain(userRepository.findFirstByID(campainSave.getUserId()));
        return campainRepository.save(campain);
    }
}
