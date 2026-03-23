package _Proj.NextDorm.RA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    // GET all RAs for a specific building
    // localhost:8080/ras/building/North Hall
    @GetMapping("/building/{building}")
    public List<RA> getRAsByBuilding(@PathVariable String building) {
        return raService.getRAsByBuilding(building);
    }

    // GET an RA by staff ID
    // localhost:8080/ras/staff/RA-001
    @GetMapping("/staff/{staffId}")
    public Optional<RA> getRAByStaffId(@PathVariable String staffId) {
        return raService.getRAByStaffId(staffId);
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
