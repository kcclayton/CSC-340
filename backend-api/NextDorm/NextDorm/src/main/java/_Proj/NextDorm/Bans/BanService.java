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

    // Update a ban
    public Ban updateBan(Long id, Ban updatedBan) {
        updatedBan.setBanId(id);
        return banRepository.save(updatedBan);
    }

    // Delete a ban record
    public void deleteBan(Long id) {
        banRepository.deleteById(id);
    }
    
}
