package _Proj.NextDorm.RA;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<RA> getAllRAs() {
        return raService.getAllRAs();
    }

    // GET an RA by ID
    // localhost:8080/ras/1
    @GetMapping("/{id}")
    public Optional<RA> getRAById(@PathVariable Long id) {
        return raService.getRAById(id);
    }

    // GET all RAs by residence description
    // localhost:8080/ras/residence/search?residenceDescription=north-hall
    @GetMapping("/residence/search")
    public List<RA> searchRAsByResidenceDescription(@RequestParam String residenceDescription) {
        return raService.searchRAsByResidenceDescription(residenceDescription);
    }

    // POST - create a new RA
    // localhost:8080/ras
    @PostMapping
    public RA createRA(@RequestBody RA ra) {
        return raService.createRA(ra);
    }

    // PUT - update an existing RA
    // localhost:8080/ras/1
    @PutMapping("/{id}")
    public RA updateRA(@PathVariable Long id, @RequestBody RA ra) {
        return raService.updateRA(id, ra);
    }

    // DELETE - remove an RA
    // localhost:8080/ras/1
    @DeleteMapping("/{id}")
    public String deleteRA(@PathVariable Long id) {
        raService.deleteRA(id);
        return "RA with ID " + id + " has been deleted.";
    }
}
