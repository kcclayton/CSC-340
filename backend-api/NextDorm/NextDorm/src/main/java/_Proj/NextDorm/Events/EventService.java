package _Proj.NextDorm.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Get all event posts
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get an event post by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Get all event posts created by a specific RA
    public List<Event> getEventsByRa(Long raId) {
        return eventRepository.findByRa_UserId(raId);
    }

    // Search event posts by description
    public List<Event> searchEventsByDescription(String description) {
        return eventRepository.findByDescriptionContainingIgnoreCase(description);
    }

    // Create a new event post
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Update an existing event post — fetch-then-patch, matching Katie's updatePost() pattern
    public Event updateEvent(Long id, Event eventDetails) {
        return eventRepository.findById(id).map(event -> {
            if (eventDetails.getOrganizationName() != null) {
                event.setOrganizationName(eventDetails.getOrganizationName());
            }
            if (eventDetails.getEventDate() != null) {
                event.setEventDate(eventDetails.getEventDate());
            }
            if (eventDetails.getLocation() != null) {
                event.setLocation(eventDetails.getLocation());
            }
            if (eventDetails.getDescription() != null) {
                event.setDescription(eventDetails.getDescription());
            }
            if (eventDetails.getRa() != null) {
                event.setRa(eventDetails.getRa());
            }
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found."));
    }

    // Delete an event post
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
