package fitness_club.web_ui.controllers.rest;

import fitness_club.core.requests.GetFitnessCenterRequest;
import fitness_club.core.responses.GetFitnessCenterResponse;
import fitness_club.core.services.GetFitnessCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fitnessCenter")
public class FitnessCenterRestController {

    @Autowired
    private GetFitnessCenterService getFitnessCenterService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetFitnessCenterResponse getFitnessCenter(@PathVariable Long id) {
        GetFitnessCenterRequest request = new GetFitnessCenterRequest(id);
        return getFitnessCenterService.execute(request);
    }
}
