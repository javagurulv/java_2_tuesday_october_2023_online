package fitness_club.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workouts")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Workouts {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout", nullable = false)
    private String workout;


}
