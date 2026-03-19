package _Proj.NextDorm.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // get user by username (used for login lookup)
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // get all users by role ("STUDENT" or "RA")
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // get all banned users
    public List<User> getBannedUsers() {
        return userRepository.findByIsBanned(true);
    }

    // search users by username substring
    public List<User> searchByUsername(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    // create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // update an existing user
    public User updateUser(Long id, User updatedUser) {
        updatedUser.setUserId(id);
        return userRepository.save(updatedUser);
    }

    // delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // ban/unban user
    public User setBanStatus(Long id, boolean isBanned) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setBanned(isBanned);
            return userRepository.save(user);
        }
        return null;
    }
}
