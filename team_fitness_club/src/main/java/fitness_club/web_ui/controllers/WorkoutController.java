package fitness_club.web_ui.controllers;

import fitness_club.core.requests.GetWorkoutRequest;
import fitness_club.core.responses.GetWorkoutResponse;
import fitness_club.core.services.GetWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WorkoutController {

    @Autowired
    private GetWorkoutService getWorkoutService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetWorkoutResponse getWorkout(@PathVariable Long id) {
        GetWorkoutRequest request = new GetWorkoutRequest(id);
        return getWorkoutService.execute(request);
    }
}
