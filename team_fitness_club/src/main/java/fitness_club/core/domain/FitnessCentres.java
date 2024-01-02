package fitness_club.core.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "fitness_centres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FitnessCentres {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fitness_centre", nullable = false)
    private String fitnessCenter;

}
