package _Proj.NextDorm.RA;

import _Proj.NextDorm.Bans.Ban;
import _Proj.NextDorm.Events.Event;
import _Proj.NextDorm.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ras")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
public class RA extends User {

    @Column(nullable = false)
    private String residenceDescription;

    // One RA creates many bans
    @OneToMany(mappedBy = "ra", cascade = CascadeType.ALL)
    @JsonManagedReference("ra-bans")
    private List<Ban> bans;

    // One RA creates many event posts
    @OneToMany(mappedBy = "ra", cascade = CascadeType.ALL)
    @JsonManagedReference("ra-events")
    private List<Event> event;

}
