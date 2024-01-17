package fitness_club.web_ui.controllers.rest;

import fitness_club.core.requests.GetWorkoutRequest;
import fitness_club.core.responses.GetWorkoutResponse;
import fitness_club.core.services.GetWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
public class WorkoutRestController {

    @Autowired
    private GetWorkoutService getWorkoutService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetWorkoutResponse getWorkout(@PathVariable Long id) {
        GetWorkoutRequest request = new GetWorkoutRequest(id);
        return getWorkoutService.execute(request);
    }
}
