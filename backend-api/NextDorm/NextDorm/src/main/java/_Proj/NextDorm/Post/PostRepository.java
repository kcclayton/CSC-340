package _Proj.NextDorm.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Query(value = "SELECT r.* FROM posts r WHERE r.student_id = :studentId", nativeQuery = true)
  List<Post> findByStudentId(Long studentId);

}
