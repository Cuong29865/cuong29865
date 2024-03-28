package huce.edu.vn.campain.repository;

import huce.edu.vn.campain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    public Vote findFirstByOrderByIdDesc();

    public Vote findFirstById(int id);
}
