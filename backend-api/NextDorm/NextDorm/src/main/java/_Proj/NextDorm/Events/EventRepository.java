package _Proj.NextDorm.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Find all events created by a specific RA
    List<Event> findByCreatedByRaId(Long raId);

    // Search events by title containing a substring
    List<Event> findByTitleContainingIgnoreCase(String title);
}
