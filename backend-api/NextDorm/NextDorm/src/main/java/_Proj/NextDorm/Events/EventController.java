package _Proj.NextDorm.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventposts")
public class EventController {

    @Autowired
    private EventService eventService;

    // GET all event posts
    // localhost:8080/eventposts
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET event post by ID
    // localhost:8080/eventposts/1
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // GET all event posts by a specific RA
    // localhost:8080/eventposts/ra/1
    @GetMapping("/ra/{raId}")
    public List<Event> getEventsByRa(@PathVariable Long raId) {
        return eventService.getEventsByRa(raId);
    }

    // GET search event posts by description
    // localhost:8080/eventposts/search?description=fire
    @GetMapping("/search")
    public List<Event> searchEventPostsByDescription(@RequestParam String description) {
        return eventService.searchEventsByDescription(description);
    }

    // POST - create a new event post
    // localhost:8080/eventposts
    @PostMapping
    public Event createEventPost(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // PUT - update an existing event post
    // localhost:8080/eventposts/1
    @PutMapping("/{id}")
    public Event updateEventPost(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // DELETE - remove an event post
    // localhost:8080/eventposts/1
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "EventPost with ID " + id + " has been deleted.";
    }
}
