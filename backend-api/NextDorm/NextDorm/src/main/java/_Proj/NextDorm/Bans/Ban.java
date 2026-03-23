package _Proj.NextDorm.Bans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "bans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banId;

    // The ID of the user who is banned
    @Column(nullable = false)
    private Long bannedUserId;

    // The ID of the RA who issued the ban
    @Column(nullable = false)
    private Long issuedByRaId;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDate startDate;

    // Null means indefinite ban
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean active;
}
