package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionRepository extends JpaRepository<Option, Integer> {
    public Option findFirstById(int id);
}
