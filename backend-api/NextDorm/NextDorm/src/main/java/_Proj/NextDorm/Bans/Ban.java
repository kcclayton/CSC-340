package _Proj.NextDorm.Bans;

import _Proj.NextDorm.RA.RA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banId;

    @Column(nullable = false)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "raId", nullable = false)
    private RA ra;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int banLength;
}
