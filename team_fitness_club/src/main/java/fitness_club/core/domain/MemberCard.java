package fitness_club.core.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    @Column(name = "age_group_id")
    private AgeGroups ageGroup;

    @ManyToOne
    @Column(name = "workout_id")
    private Workouts workouts;

    @ManyToOne
    @Column(name = "fitness_centre_id")
    private FitnessCentres fitnessCentre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "term_of_contract")
    private Date termOfContract;


}
