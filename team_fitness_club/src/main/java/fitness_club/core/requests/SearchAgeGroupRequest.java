package fitness_club.core.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchAgeGroupRequest {

    private String ageGroup;

    public boolean isAgeGroupProvided() {
        return this.ageGroup != null;
    }

}
