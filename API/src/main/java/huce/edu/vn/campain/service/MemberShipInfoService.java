package huce.edu.vn.campain.service;

import huce.edu.vn.campain.BodyRequest.MemberShipInfoSave;
import huce.edu.vn.campain.entity.MemberShipInfo;
import huce.edu.vn.campain.repository.MemberShipInfoRepository;
import huce.edu.vn.campain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberShipInfoService {
    @Autowired
    private MemberShipInfoRepository memberShipInfoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<MemberShipInfo> getAllMemberShipInfo(){
        return memberShipInfoRepository.findAll();
    }

    public MemberShipInfo addMemberShipInfo(MemberShipInfoSave memberShipInfoSave){
        MemberShipInfo memberShipInfo = new MemberShipInfo();
        memberShipInfo.setUserToMemberShipInfo(userRepository.findFirstByID(memberShipInfoSave.getUserId()));
        memberShipInfo.setPhone(memberShipInfo.getPhone());
        memberShipInfo.setAddress(memberShipInfo.getAddress());
        memberShipInfo.setAvatar(memberShipInfo.getAvatar());
        memberShipInfo.setOrganization(memberShipInfo.getOrganization());
        return memberShipInfoRepository.save(memberShipInfo);
    }

    public MemberShipInfo deleteMemberShipInfo(int id){
        MemberShipInfo memberShipInfo = memberShipInfoRepository.findFirstByUserToMemberShipInfo_ID(id);
        memberShipInfoRepository.delete(memberShipInfo);
        return memberShipInfo;
    }

    public MemberShipInfo updateMemberShipInfo(MemberShipInfoSave memberShipInfoSave){
        MemberShipInfo memberShipInfo = memberShipInfoRepository.findFirstByUserToMemberShipInfo_ID(memberShipInfoSave.getUserId());
        memberShipInfo.setPhone(memberShipInfoSave.getPhone());
        memberShipInfo.setAddress(memberShipInfo.getAddress());
        memberShipInfo.setAvatar(memberShipInfo.getAvatar());
        memberShipInfo.setOrganization(memberShipInfo.getOrganization());
        return memberShipInfoRepository.save(memberShipInfo);
    }
}
