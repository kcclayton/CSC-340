package _Proj.NextDorm.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET - all users
    // localhost:8080/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET - user by ID
    // localhost:8080/users/1
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // GET - user by username
    // localhost:8080/users/username/johndoe
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // GET - users by role
    // localhost:8080/users/role/STUDENT or /role/RA
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    // GET - all banned users
    // localhost:8080/users/banned
    @GetMapping("/banned")
    public List<User> getBannedUsers() {
        return userService.getBannedUsers();
    }

    // GET - search users by username substring
    // localhost:8080/users/search?username=john
    @GetMapping("/search")
    public List<User> searchByUsername(@RequestParam String username) {
        return userService.searchByUsername(username);
    }

    // POST - create a new user
    // localhost:8080/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT - update an existing user
    // localhost:8080/users/1
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // PUT - ban or unban a user (US-PROV-005)
    // localhost:8080/users/1/ban?status=true
    @PutMapping("/{id}/ban")
    public User setBanStatus(@PathVariable Long id, @RequestParam boolean status) {
        return userService.setBanStatus(id, status);
    }

    // DELETE - delete a user
    // localhost:8080/users/1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }
}
