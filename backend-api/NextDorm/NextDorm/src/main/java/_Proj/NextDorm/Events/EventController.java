package _Proj.NextDorm.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // GET all events
    // localhost:8080/events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET event by ID
    // localhost:8080/events/1
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // GET all events created by a specific RA
    // localhost:8080/events/ra/1
    @GetMapping("/ra/{raId}")
    public List<Event> getEventsByRa(@PathVariable Long raId) {
        return eventService.getEventsByRa(raId);
    }

    // GET search events by title
    // localhost:8080/events/search?title=fire
    @GetMapping("/search")
    public List<Event> searchEventsByTitle(@RequestParam String title) {
        return eventService.searchEventsByTitle(title);
    }

    // POST - create a new event
    // localhost:8080/events
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // PUT - update an existing event
    // localhost:8080/events/1
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // DELETE - remove an event
    // localhost:8080/events/1
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event with ID " + id + " has been deleted.";
    }
}
