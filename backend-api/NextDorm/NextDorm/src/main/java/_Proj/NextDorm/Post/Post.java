package _Proj.NextDorm.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import _Proj.NextDorm.Student.Student;
import _Proj.NextDorm.Reply.Reply;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    @Column
    private String postTitle;

    @Column
    private String postContent;

    @Column
    private String postTag;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"posts", "replies"})
    private Student student;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"post", "student"})
    private List<Reply> replies;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


}
