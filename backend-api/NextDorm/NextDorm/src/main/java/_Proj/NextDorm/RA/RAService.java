package _Proj.NextDorm.RA;
import _Proj.NextDorm.User.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RAService {

    @Autowired
    private RARepository raRepository;

    // Get all RAs
    public List<RA> getAllRAs() {
        return raRepository.findAll();
    }

    // Get an RA by ID
    public Optional<RA> getRAById(Long id) {
        return raRepository.findById(id);
    }

    // Get all RAs by residence description
    public List<RA> getRAsByResidenceDescription(String residenceDescription) {
        return raRepository.findByResidenceDescription(residenceDescription);
    }

    // Create a new RA
    public RA createRA(RA ra) {
        ra.setRole(User.UserRole.RA);
        return raRepository.save(ra);
    }

    // Update an existing RA
    public RA updateRA(Long id, RA updatedRA) {
        updatedRA.setUserId(id);
        return raRepository.save(updatedRA);
    }

    // Delete an RA
    public void deleteRA(Long id) {
        raRepository.deleteById(id);
    }

}
