package _Proj.NextDorm.Bans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {

    // Find all bans for a specific student
    List<Ban> findByStudentId(Long studentId);

    // Find all bans issued by a specific RA
    List<Ban> findByRa_UserId(Long raId);
    
}
