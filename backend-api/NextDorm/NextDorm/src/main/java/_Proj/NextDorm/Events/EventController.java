package _Proj.NextDorm.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eventposts")
public class EventController {

    @Autowired
    private EventService eventService;

    // GET all event posts
    // localhost:8080/eventposts
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // GET event post by ID
    // localhost:8080/eventposts/1
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET all event posts by a specific RA
    // localhost:8080/eventposts/ra/1
    @GetMapping("/ra/{raId}")
    public ResponseEntity<List<Event>> getEventsByRa(@PathVariable Long raId) {
        List<Event> events = eventService.getEventsByRa(raId);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // GET search event posts by description
    // localhost:8080/eventposts/search?description=fire
    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEventsByDescription(@RequestParam String description) {
        List<Event> events = eventService.searchEventsByDescription(description);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // POST - create a new event post
    // localhost:8080/eventposts
    @PostMapping
    public ResponseEntity<Event> createEventPost(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    // PUT - update an existing event post
    // localhost:8080/eventposts/1
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEventPost(@PathVariable Long id, @RequestBody Event event) {
        try {
            Event updatedEvent = eventService.updateEvent(id, event);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - remove an event post
    // localhost:8080/eventposts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
