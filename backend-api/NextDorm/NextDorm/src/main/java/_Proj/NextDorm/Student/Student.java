package _Proj.NextDorm.Student;
import _Proj.NextDorm.User.*;
import _Proj.NextDorm.Post.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "student_id")

public class Student extends User {
    
    @Column(nullable = false)
    private String residenceHall;

    @Column
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private studentStatus status;


    public enum studentStatus {
        ACTIVE,
        SUSPENDED,
        BANNED
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("student")
    private List<Post> posts;

    
}
