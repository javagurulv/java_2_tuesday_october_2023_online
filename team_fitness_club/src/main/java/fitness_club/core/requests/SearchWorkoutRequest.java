package fitness_club.core.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchWorkoutRequest {

    private String workout;

    public boolean isWorkoutProvided() {
        return this.workout != null;
    }

}
