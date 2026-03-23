package _Proj.NextDorm.RA;

import _Proj.NextDorm.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ras")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
public class RA extends User {

    // The building or hall this RA is responsible for
    @Column(nullable = false)
    private String building;

    // The floor or section this RA manages
    private String floorSection;

    // Employee/staff ID for verification
    @Column(nullable = false, unique = true)
    private String staffId;
}
