package _Proj.NextDorm.Bans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BanService {

    @Autowired
    private BanRepository banRepository;

    // Get all bans
    public List<Ban> getAllBans() {
        return banRepository.findAll();
    }

    // Get a ban by ID
    public Optional<Ban> getBanById(Long id) {
        return banRepository.findById(id);
    }

    // Get all bans for a specific student
    public List<Ban> getBansByStudent(Long studentId) {
        return banRepository.findByStudentId(studentId);
    }

    // Get all bans issued by a specific RA
    public List<Ban> getBansByRa(Long raId) {
        return banRepository.findByRa_UserId(raId);
    }

    // Issue a new ban
    public Ban issueBan(Ban ban) {
        return banRepository.save(ban);
    }

    // Update a ban — fetch-then-patch, matching Katie's updatePost() pattern
    public Ban updateBan(Long id, Ban banDetails) {
        return banRepository.findById(id).map(ban -> {
            if (banDetails.getStudentId() != null) {
                ban.setStudentId(banDetails.getStudentId());
            }
            if (banDetails.getDescription() != null) {
                ban.setDescription(banDetails.getDescription());
            }
            if (banDetails.getRa() != null) {
                ban.setRa(banDetails.getRa());
            }
            ban.setBanLength(banDetails.getBanLength());
            return banRepository.save(ban);
        }).orElseThrow(() -> new RuntimeException("Ban not found."));
    }

    // Delete a ban record
    public void deleteBan(Long id) {
        banRepository.deleteById(id);
    }

}
