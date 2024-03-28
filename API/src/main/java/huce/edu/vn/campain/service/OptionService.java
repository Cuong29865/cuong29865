package huce.edu.vn.campain.service;

import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.repository.CampainRepository;
import huce.edu.vn.campain.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private CampainRepository campainRepository;

    public Option addNewOption(int campain, String description, String image, String title){
        Option option = new Option();
        option.setCampainToOption(campainRepository.findFirstById(campain));
        option.setDescription(description);
        option.setImage(image);
        option.setTitle(title);
        optionRepository.save(option);
        return optionRepository.findFirstByOrderByIdDesc();
    }

    public Option updateOption(int optionId, String description, String image, String title){
        Option option = optionRepository.findFirstById(optionId);
        option.setDescription(description);
        option.setImage(image);
        option.setTitle(title);
        return optionRepository.save(option);
    }
}
