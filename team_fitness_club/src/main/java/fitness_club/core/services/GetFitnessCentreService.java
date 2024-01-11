package fitness_club.core.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GetFitnessCentreService {

   /* public static FitnessCentres getFitnessCentre(int id) {
        FitnessCentres selectedFitnessCentre = null;
        switch (id) {
            case 1 -> selectedFitnessCentre = FitnessCentres.AKROPOLE;
            case 2 -> selectedFitnessCentre = FitnessCentres.IMANTA;
            case 3 -> selectedFitnessCentre = FitnessCentres.RIGA_PLAZA;
            case 4 -> selectedFitnessCentre = FitnessCentres.SAGA;
            case 5 -> selectedFitnessCentre = FitnessCentres.ZOLITUDE;
            default -> System.out.println("No such fitness centre.");
        }
        return selectedFitnessCentre;
    }

    */
}
