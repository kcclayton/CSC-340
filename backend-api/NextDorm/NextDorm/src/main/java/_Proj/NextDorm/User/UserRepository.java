package _Proj.NextDorm.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their username (used for login)
    User findByUsername(String username);

    // Find all users by role - e.g. "STUDENT" or "RA"
    List<User> findByRole(String role);

    // Find all users who are currently banned
    List<User> findByIsBanned(boolean isBanned);

    // Search users by username containing a substring
    List<User> findByUsernameContainingIgnoreCase(String username);
}
