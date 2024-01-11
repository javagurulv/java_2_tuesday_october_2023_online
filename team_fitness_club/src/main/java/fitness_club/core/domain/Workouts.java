package fitness_club.core.domain;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "workouts")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Workouts {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout", nullable = false)
    private Workouts workout;

    public Workouts(Workouts workout) {
        this.workout = workout;
    }
}
