package fitness_club.core.domain;


import lombok.*;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member_card")
@Setter
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
    @JoinColumn(name = "age_group_id", nullable = false)
    private AgeGroups ageGroup;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workouts workout;

    @ManyToOne
    @JoinColumn(name = "fitness_centre_id", nullable = false)
    private FitnessCenters fitnessCentre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "term_of_contract", nullable = false)
    private Date termOfContract;

    @OneToMany(mappedBy="workout", fetch=FetchType.EAGER)
    private List<Workouts> workouts;

    public MemberCard(Client client, AgeGroups ageGroup, Workouts workout, FitnessCenters fitnessCentre, Date termOfContract) {
        this.client = client;
        this.ageGroup = ageGroup;
        this.workout = workout;
        this.fitnessCentre = fitnessCentre;
        this.termOfContract = termOfContract;
    }
}
