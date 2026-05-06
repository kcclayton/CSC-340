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

    // Get an RA by email
    public RA getRAByEmail(String email) {
        return raRepository.findByEmail(email);
    }

    // Search all RAs by residence description
    public List<RA> searchRAsByResidenceDescription(String residenceDescription) {
        return raRepository.findByResidenceDescriptionContainingIgnoreCase(residenceDescription);
    }

    // Create a new RA
    public RA createRA(RA ra) {
        ra.setRole(User.UserRole.RA);
        return raRepository.save(ra);
    }

    // Update an existing RA — fetch-then-patch, matching Katie's updateStudent()
    public RA updateRA(Long id, RA raDetails) {
        return raRepository.findById(id).map(ra -> {
            if (raDetails.getName() != null) {
                ra.setName(raDetails.getName());
            }
            if (raDetails.getEmail() != null) {
                ra.setEmail(raDetails.getEmail());
            }
            if (raDetails.getUserPassword() != null) {
                ra.setUserPassword(raDetails.getUserPassword());
            }
            if (raDetails.getUsername() != null) {
                ra.setUsername(raDetails.getUsername());
            }
            if (raDetails.getResidenceDescription() != null) {
                ra.setResidenceDescription(raDetails.getResidenceDescription());
            }
            return raRepository.save(ra);
        }).orElseThrow(() -> new RuntimeException("RA not found."));
    }

    // Delete an RA
    public void deleteRA(Long id) {
        raRepository.deleteById(id);
    }

    // Authenticate an RA by email and password — mirrors StudentService.authenticate()
    public RA authenticate(String email, String password) {
        RA ra = getRAByEmail(email);
        if (ra != null && ra.getUserPassword().equals(password)) {
            return ra;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

}
