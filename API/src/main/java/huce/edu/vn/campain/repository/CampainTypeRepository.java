package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.CampainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampainTypeRepository extends JpaRepository<CampainType, Integer> {
    public CampainType findFirstById(int id);
}
