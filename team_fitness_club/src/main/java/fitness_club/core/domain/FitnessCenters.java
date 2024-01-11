package fitness_club.core.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "fitness_centers")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class FitnessCenters {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fitness_center", nullable = false)
    private FitnessCenters fitnessCenter;

    public FitnessCenters(FitnessCenters fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }
}
