package fitness_club.core.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "age_groups")
@Getter
@NoArgsConstructor

public class AgeGroups {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_group", nullable = false)
    private AgeGroups ageGroup;

    public AgeGroups(AgeGroups ageGroup) {
        this.ageGroup =ageGroup;
    }
}
