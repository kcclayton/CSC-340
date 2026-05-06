package _Proj.NextDorm.RA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ras")
public class RAController {

    @Autowired
    private RAService raService;

    // GET all RAs
    // localhost:8080/ras
    @GetMapping
    public ResponseEntity<List<RA>> getAllRAs() {
        List<RA> ras = raService.getAllRAs();
        return new ResponseEntity<>(ras, HttpStatus.OK);
    }

    // GET an RA by ID
    // localhost:8080/ras/1
    @GetMapping("/{id}")
    public ResponseEntity<RA> getRAById(@PathVariable Long id) {
        Optional<RA> ra = raService.getRAById(id);
        return ra.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET all RAs by residence description
    // localhost:8080/ras/residence/search?residenceDescription=north-hall
    @GetMapping("/residence/search")
    public ResponseEntity<List<RA>> searchRAsByResidenceDescription(@RequestParam String residenceDescription) {
        List<RA> ras = raService.searchRAsByResidenceDescription(residenceDescription);
        return new ResponseEntity<>(ras, HttpStatus.OK);
    }

    // POST - create a new RA
    // localhost:8080/ras
    @PostMapping
    public ResponseEntity<RA> createRA(@RequestBody RA ra) {
        RA createdRA = raService.createRA(ra);
        return new ResponseEntity<>(createdRA, HttpStatus.CREATED);
    }

    // PUT - update an existing RA
    // localhost:8080/ras/1
    @PutMapping("/{id}")
    public ResponseEntity<RA> updateRA(@PathVariable Long id, @RequestBody RA ra) {
        Optional<RA> existing = raService.getRAById(id);
        if (existing.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            RA updatedRA = raService.updateRA(id, ra);
            return new ResponseEntity<>(updatedRA, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("Error updating RA: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE - remove an RA
    // localhost:8080/ras/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRA(@PathVariable Long id) {
        raService.deleteRA(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
