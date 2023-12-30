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

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "workout")
    private String workouts;

    @Column(name = "fitness_centre")
    private String fitnessCentre;

    @Column(name = "term_of_contract")
    private Date termOfContract;

    public MemberCard(Client client, String clientAgeGroup, String workouts, String fitnessCentre, Date termOfContract) {
        this.client = client;
        this.ageGroup = ageGroup;
        this.workouts = workouts;
        this.fitnessCentre = fitnessCentre;
        this.termOfContract = termOfContract;
    }
}
