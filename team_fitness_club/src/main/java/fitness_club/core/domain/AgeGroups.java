package fitness_club.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "age_groups")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AgeGroups {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_group", nullable = false)
    private String ageGroup;

    public AgeGroups(String ageGroup) {
        this.ageGroup =ageGroup;
    }
}
