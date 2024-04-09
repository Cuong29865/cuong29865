package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.Campain;
import huce.edu.vn.campain.entity.Option;
import huce.edu.vn.campain.entityConnect.CampainMore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CampainRepository extends JpaRepository<Campain, Integer> {
    @Query("select option from Campain campain inner join campain.optionsFromCampain option on campain.id = option.campainToOption.id " +
            "where campain.id = :id")
    public List<Option> findAllOptionByCampain(@Param("id") int id);

    @Query("select new huce.edu.vn.campain.entityConnect.CampainMore(campain.title, campain.description, campain.start, campain.end, campain.status" +
            ", campain.metadata, campain.result, user.email, memberShipInfo.organization, campainType.fieldType) from Campain campain inner join campain.userToCampain user on " +
            "user.ID = campain.userToCampain.ID inner join user.memberShipInfosFromUser memberShipInfo on memberShipInfo.userToMemberShipInfo.ID = user.ID " +
            "inner join campain.campainTypeToCampain campainType on campainType.id = campain.campainTypeToCampain.id " +
            "where campain.id = :id")
    public List<CampainMore> findCampainByTitle(@Param("id") int id);

    @Query("select new huce.edu.vn.campain.entityConnect.CampainMore(campain.title, campain.description, campain.start, campain.end, campain.status" +
            ", campain.metadata, campain.result, user.email, memberShipInfo.organization, campainType.fieldType) from Campain campain inner join campain.userToCampain user on " +
            "user.ID = campain.userToCampain.ID inner join user.memberShipInfosFromUser memberShipInfo on memberShipInfo.userToMemberShipInfo.ID = user.ID " +
            "inner join campain.campainTypeToCampain campainType on campainType.id = campain.campainTypeToCampain.id " +
            "where campainType.fieldType = :type")
    public List<CampainMore> findCampainByType(@Param("type") String type);

    @Query("select new huce.edu.vn.campain.entityConnect.CampainMore(campain.title, campain.description, campain.start, campain.end, campain.status" +
            ", campain.metadata, campain.result, user.email, memberShipInfo.organization, campainType.fieldType) from Campain campain inner join campain.userToCampain user on " +
            "user.ID = campain.userToCampain.ID inner join user.memberShipInfosFromUser memberShipInfo on memberShipInfo.userToMemberShipInfo.ID = user.ID " +
            "inner join campain.campainTypeToCampain campainType on campainType.id = campain.campainTypeToCampain.id " +
            "where campain.start >= :start and campain.end <= :end")
    public List<CampainMore> findCampainByStartAndEnd(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    public Campain findFirstById(int id);

    public Campain findFirstByOrderByIdDesc();
}
