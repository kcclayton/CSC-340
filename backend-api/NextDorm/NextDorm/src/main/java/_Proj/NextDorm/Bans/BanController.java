package _Proj.NextDorm.Bans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Ban>> getAllBans() {
        List<Ban> bans = banService.getAllBans();
        return new ResponseEntity<>(bans, HttpStatus.OK);
    }

    // GET ban by ID
    // localhost:8080/bans/1
    @GetMapping("/{id}")
    public ResponseEntity<Ban> getBanById(@PathVariable Long id) {
        Optional<Ban> ban = banService.getBanById(id);
        return ban.map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET all bans for a specific student
    // localhost:8080/bans/student/1
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Ban>> getBansByStudent(@PathVariable Long studentId) {
        List<Ban> bans = banService.getBansByStudent(studentId);
        return new ResponseEntity<>(bans, HttpStatus.OK);
    }

    // GET all bans issued by a specific RA
    // localhost:8080/bans/ra/1
    @GetMapping("/ra/{raId}")
    public ResponseEntity<List<Ban>> getBansByRa(@PathVariable Long raId) {
        List<Ban> bans = banService.getBansByRa(raId);
        return new ResponseEntity<>(bans, HttpStatus.OK);
    }

    // POST - issue a new ban
    // localhost:8080/bans
    @PostMapping
    public ResponseEntity<Ban> issueBan(@RequestBody Ban ban) {
        Ban createdBan = banService.issueBan(ban);
        return new ResponseEntity<>(createdBan, HttpStatus.CREATED);
    }

    // PUT - update an existing ban
    // localhost:8080/bans/1
    @PutMapping("/{id}")
    public ResponseEntity<Ban> updateBan(@PathVariable Long id, @RequestBody Ban ban) {
        try {
            Ban updatedBan = banService.updateBan(id, ban);
            return new ResponseEntity<>(updatedBan, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - remove a ban record
    // localhost:8080/bans/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBan(@PathVariable Long id) {
        banService.deleteBan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
