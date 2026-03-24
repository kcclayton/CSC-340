package _Proj.NextDorm.Reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

  @Query(value = "SELECT r.* FROM replies r WHERE r.post_id = :postId", nativeQuery = true)
  List<Reply> findByPostId(Long postId);

  @Query(value = "SELECT r.* FROM replies r WHERE r.student_id = :studentId", nativeQuery = true)
  List<Reply> findByStudentId(Long studentId);

}
