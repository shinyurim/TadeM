package project.TadeM.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.Admin.Entity.Qna;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {

}
