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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @OneToMany(mappedBy = "ra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"ra"})
    private List<Ban> bans;

    @OneToMany(mappedBy = "ra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"ra"})
    private List<Event> event;

}
