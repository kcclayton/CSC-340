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

    // Get all bans for a specific user
    public List<Ban> getBansByUser(Long userId) {
        return banRepository.findByBannedUserId(userId);
    }

    // Get all currently active bans
    public List<Ban> getActiveBans() {
        return banRepository.findByActive(true);
    }

    // Get all bans issued by a specific RA
    public List<Ban> getBansByRa(Long raId) {
        return banRepository.findByIssuedByRaId(raId);
    }

    // Issue a new ban
    public Ban issueBan(Ban ban) {
        ban.setActive(true);
        return banRepository.save(ban);
    }

    // Update a ban
    public Ban updateBan(Long id, Ban updatedBan) {
        updatedBan.setBanId(id);
        return banRepository.save(updatedBan);
    }

    // Lift a ban (set active to false)
    public Ban liftBan(Long id) {
        Optional<Ban> optional = banRepository.findById(id);
        if (optional.isPresent()) {
            Ban ban = optional.get();
            ban.setActive(false);
            return banRepository.save(ban);
        }
        return null;
    }

    // Delete a ban record
    public void deleteBan(Long id) {
        banRepository.deleteById(id);
    }
}
