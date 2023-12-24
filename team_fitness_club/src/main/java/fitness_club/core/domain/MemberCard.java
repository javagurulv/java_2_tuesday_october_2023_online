package fitness_club.core.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_card")
@Getter
@Setter
@NoArgsConstructor
public class MemberCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "age_group_id")
    private Long ageGroupId;

    @Column(name = "workout_id")
    private Long workoutId;

    @Column(name = "fitness_centre_id")
    private Long fitnessCentreId;

    @Column(name = "term_of_contract")
    private Date termOfContract;

    public MemberCard(Long clientId, Long ageGroupId, Long workoutId, Long fitnessCentreId, Date termOfContract) {
        this.clientId = clientId;
        this.ageGroupId = ageGroupId;
        this.workoutId = workoutId;
        this.fitnessCentreId = fitnessCentreId;
        this.termOfContract = termOfContract;
    }
}
