package _Proj.NextDorm.RA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RARepository extends JpaRepository<RA, Long> {

    // Find all RAs by residence description
    List<RA> findByResidenceDescriptionContainingIgnoreCase(String residenceDescription);

    // Find an RA by email (used for authentication)
    RA findByEmail(String email);

}
