package fitness_club.services;

import fitness_club.domain.ClientAgeGroups;

public class GetClientAgeGroupService {
    public static ClientAgeGroups getClientAgeGroup(int id) {
        ClientAgeGroups selectedClientAgeGroup = null;
        switch (id){
            case 1 ->selectedClientAgeGroup = ClientAgeGroups.CHILD;
            case 2 -> selectedClientAgeGroup = ClientAgeGroups.ADULT;
            case 3 -> selectedClientAgeGroup = ClientAgeGroups.SENIOR;
            default -> System.out.println("No such client age group option");
        }
        return selectedClientAgeGroup;
    }
}
