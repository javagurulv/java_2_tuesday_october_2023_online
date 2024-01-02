package fitness_club.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "workouts")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Workouts {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout", nullable = false)
    private Workouts workout;
}
