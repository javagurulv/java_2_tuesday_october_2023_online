package fitness_club.core.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_card")
@Getter
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

    @ManyToOne
    @Column(name = "age_group_id")
    private AgeGroups ageGroups;

    @ManyToOne
    @Column(name = "workout_id")
    private Workouts workouts;

    @ManyToOne
    @Column(name = "fitness_centre_id")
    private FitnessCentres fitnessCentre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "term_of_contract")
    private Date termOfContract;


    public MemberCard(Client client,AgeGroups ageGroups, Workouts workouts, FitnessCentres fitnessCentre) {
        this.client = client;
        this.ageGroups = ageGroups;
        this.workouts = workouts;
        this.fitnessCentre = fitnessCentre;
    }

    public MemberCard(Client client){
        this.client =client;
    }


    public MemberCard(Client client, AgeGroups ageGroups) {
    }
}
