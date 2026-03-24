package _Proj.NextDorm.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Find all event posts created by a specific RA
    List<Event> findByRa_UserId(Long raId);

    // Search event posts by description containing a substring
    List<Event> findByDescriptionContainingIgnoreCase(String description);
}
