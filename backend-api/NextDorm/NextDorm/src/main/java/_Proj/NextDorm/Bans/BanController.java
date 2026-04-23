package _Proj.NextDorm.Bans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bans")
public class BanController {

    @Autowired
    private BanService banService;

    // GET all bans
    // localhost:8080/bans
    @GetMapping
    public List<Ban> getAllBans() {
        return banService.getAllBans();
    }

    // GET ban by ID
    // localhost:8080/bans/1
    @GetMapping("/{id}")
    public Optional<Ban> getBanById(@PathVariable Long id) {
        return banService.getBanById(id);
    }

    // GET all bans for a specific student
    // localhost:8080/bans/student/1
    @GetMapping("/student/{studentId}")
    public List<Ban> getBansByStudent(@PathVariable Long studentId) {
        return banService.getBansByStudent(studentId);
    }

    // GET all bans issued by a specific RA
    // localhost:8080/bans/ra/1
    @GetMapping("/ra/{raId}")
    public List<Ban> getBansByRa(@PathVariable Long raId) {
        return banService.getBansByRa(raId);
    }

    // POST - issue a new ban
    // localhost:8080/bans
    @PostMapping
    public Ban issueBan(@RequestBody Ban ban) {
        return banService.issueBan(ban);
    }

    // PUT - update an existing ban
    // localhost:8080/bans/1
    @PutMapping("/{id}")
    public Ban updateBan(@PathVariable Long id, @RequestBody Ban ban) {
        return banService.updateBan(id, ban);
    }

    // DELETE - remove a ban record
    // localhost:8080/bans/1
    @DeleteMapping("/{id}")
    public String deleteBan(@PathVariable Long id) {
        banService.deleteBan(id);
        return "Ban with ID " + id + " has been deleted.";
    }

}