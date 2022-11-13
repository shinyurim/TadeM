package project.TadeM.Admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.Admin.Entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
