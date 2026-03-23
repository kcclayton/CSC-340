package _Proj.NextDorm.RA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RARepository extends JpaRepository<RA, Long> {

    // Find all RAs for a specific building
    List<RA> findByBuilding(String building);

    // Find an RA by their staff ID
    Optional<RA> findByStaffId(String staffId);
}
