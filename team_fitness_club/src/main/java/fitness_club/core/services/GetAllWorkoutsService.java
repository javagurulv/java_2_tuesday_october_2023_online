package fitness_club.core.services;

import fitness_club.core.database.WorkoutRepositoryImpl;
import fitness_club.core.database.jpa.JpaFitnessCentersRepository;
import fitness_club.core.database.jpa.JpaWorkoutsRepository;
import fitness_club.core.domain.Workout;
import fitness_club.core.requests.GetAllWorkoutsRequest;
import fitness_club.core.responses.GetAllWorkoutsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllWorkoutsService {

    @Autowired
    private JpaWorkoutsRepository workoutsRepository;

    public GetAllWorkoutsResponse execute(GetAllWorkoutsRequest request) {
        List<Workout> workouts = workoutsRepository.findAll();
        return new GetAllWorkoutsResponse(workouts);
    }
}
