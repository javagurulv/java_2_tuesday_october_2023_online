package fitness_club.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberCardDto {

    private String firstName;
    private String lastName;
    private String personalCode;
    private String ageGroup;
    private String workout;
    private String fitnessCentre;
    private Date termOfContract;

}
