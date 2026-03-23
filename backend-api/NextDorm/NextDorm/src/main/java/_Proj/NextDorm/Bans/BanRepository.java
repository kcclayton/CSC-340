package _Proj.NextDorm.Bans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {

    // Find all bans for a specific user
    List<Ban> findByBannedUserId(Long bannedUserId);

    // Find all active bans
    List<Ban> findByActive(boolean active);

    // Find all bans issued by a specific RA
    List<Ban> findByIssuedByRaId(Long raId);
}
