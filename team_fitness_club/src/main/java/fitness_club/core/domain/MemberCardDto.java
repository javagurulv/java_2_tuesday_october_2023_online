package fitness_club.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberCardDto {
    private String firstName;
    private String lastName;
    private String personalCode;
    private String ageGroup;
    private String workout;
    private String fitnessCentre;
    private Date termOfContract;

    public MemberCardDto(String firstName, String lastName, String personalCode,
                         String ageGroup, String workout, String fitnessCentre, Date termOfContract) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.ageGroup = ageGroup;
        this.workout = workout;
        this.fitnessCentre = fitnessCentre;
        this.termOfContract = termOfContract;
    }
}
