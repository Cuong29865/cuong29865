package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
    public Option findFirstByOrderByIdDesc();

    public Option findFirstById(int id);
}
