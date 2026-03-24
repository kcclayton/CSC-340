package _Proj.NextDorm.Events;

import _Proj.NextDorm.RA.RA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false)
    private String eventDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "raId", nullable = false)
    private RA ra;
}
