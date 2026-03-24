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
    private List<Ban> bans;

    // One RA creates many event posts
    @OneToMany(mappedBy = "ra", cascade = CascadeType.ALL)
    private List<Event> event;

}
