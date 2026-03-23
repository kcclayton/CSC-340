package _Proj.NextDorm.Reply;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import _Proj.NextDorm.Post.Post;
import _Proj.NextDorm.Student.Student;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyID;

    @Column(nullable = false)
    private String replyContent;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnoreProperties({"replies", "student"})
    private Post post;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
@   JsonIgnoreProperties({"posts", "replies"}) 
    private Student student;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
