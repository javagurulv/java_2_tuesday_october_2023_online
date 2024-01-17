package fitness_club.web_ui.controllers.rest;

import fitness_club.core.requests.*;
import fitness_club.core.responses.*;
import fitness_club.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ageGroup")
public class AgeGroupRestController {

    @Autowired
    private GetAgeGroupService getAgeGroupService;


    @GetMapping(path = "/{id}", produces = "application/json")
    public GetAgeGroupResponse getAgeGroup(@PathVariable Long id) {
        GetAgeGroupRequest request = new GetAgeGroupRequest(id);
        return getAgeGroupService.execute(request);
    }
}
