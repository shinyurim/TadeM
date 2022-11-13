package project.TadeM.requestBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.requestBoard.entity.requestBoard;

@Repository
public interface boardRepository extends JpaRepository<requestBoard, Long> {

}
