package fitness_club.core.services;

import fitness_club.core.domain.FitnessCentre;

public class GetFitnessCentreService {

    public static FitnessCentre getFitnessCentre(int id) {
        FitnessCentre selectedFitnessCentre = null;
        switch (id) {
            case 1 -> selectedFitnessCentre = FitnessCentre.AKROPOLE;
            case 2 -> selectedFitnessCentre = FitnessCentre.IMANTA;
            case 3 -> selectedFitnessCentre = FitnessCentre.RIGA_PLAZA;
            case 4 -> selectedFitnessCentre = FitnessCentre.SAGA;
            case 5 -> selectedFitnessCentre = FitnessCentre.ZOLITUDE;
            default -> System.out.println("No such fitness centre.");
        }
        return selectedFitnessCentre;
    }
}
