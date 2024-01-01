package fitness_club.core.services;

import fitness_club.core.domain.AgeGroups;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GetClientAgeGroupService {
   /* public static AgeGroups getClientAgeGroup(int id) {
        AgeGroups selectedClientAgeGroup = null;
        switch (id){
            case 1 ->selectedClientAgeGroup = AgeGroups.CHILD;
            case 2 -> selectedClientAgeGroup = AgeGroups.ADULT;
            case 3 -> selectedClientAgeGroup = AgeGroups.SENIOR;
            default -> System.out.println("No such client age group option");
        }
        return selectedClientAgeGroup;
    }

    */
}
