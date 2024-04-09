package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.Id.MemberShipInfoId;
import huce.edu.vn.campain.entity.MemberShipInfo;
import huce.edu.vn.campain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipInfoRepository extends JpaRepository<MemberShipInfo, MemberShipInfoId> {
    public MemberShipInfo findFirstByUserToMemberShipInfo_ID(int id);
}
