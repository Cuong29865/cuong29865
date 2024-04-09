package huce.edu.vn.campain.service;

import huce.edu.vn.campain.BodyRequest.CampainTypeSave;
import huce.edu.vn.campain.entity.CampainType;
import huce.edu.vn.campain.repository.CampainRepository;
import huce.edu.vn.campain.repository.CampainTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampainTypeService {
    @Autowired
    private CampainTypeRepository campainTypeRepository;
    @Autowired
    private CampainRepository campainRepository;

    public List<CampainType> getAllCampainType(){
        return campainTypeRepository.findAll();
    }

    public CampainType addCampainType(CampainTypeSave campainTypeSave){
        CampainType campainType = new CampainType();
        campainType.setFieldType(campainType.getFieldType());
        campainType.setDescription(campainType.getDescription());
        return campainTypeRepository.save(campainType);
    }

    public CampainType deleteCampainType(int campainTypeId){
        CampainType campainType = campainTypeRepository.findFirstById(campainTypeId);
        campainTypeRepository.delete(campainType);
        return campainType;
    }

    public CampainType updateCampainType(int campainTypeId, CampainTypeSave campainTypeSave){
        CampainType campainType = campainTypeRepository.findFirstById(campainTypeId);
        campainType.setFieldType(campainType.getFieldType());
        campainType.setDescription(campainType.getDescription());
        return campainTypeRepository.save(campainType);
    }
}
