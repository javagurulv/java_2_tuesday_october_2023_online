package fitness_club.core.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "age_groups")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AgeGroup {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_group", nullable = false)
    private String ageGroup;


}
