package _Proj.NextDorm.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get an event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Get all events created by a specific RA
    public List<Event> getEventsByRa(Long raId) {
        return eventRepository.findByCreatedByRaId(raId);
    }

    // Search events by title
    public List<Event> searchEventsByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    // Create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Update an existing event
    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setTitle(updatedEvent.getTitle());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setEventDate(updatedEvent.getEventDate());
            existingEvent.setLocation(updatedEvent.getLocation());
            existingEvent.setCreatedByRaId(updatedEvent.getCreatedByRaId());
            return eventRepository.save(existingEvent);
        }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // Delete an event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
