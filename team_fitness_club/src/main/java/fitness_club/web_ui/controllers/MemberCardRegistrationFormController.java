package fitness_club.web_ui.controllers;

import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaFitnessCentersRepository;
import fitness_club.core.database.jpa.JpaWorkoutsRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;
import fitness_club.core.requests.*;
import fitness_club.core.responses.*;
import fitness_club.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class MemberCardRegistrationFormController {

    @Autowired
    private MemberCardRegistrationFormService memberCardRegistrationService;
    @Autowired
    private JpaWorkoutsRepository workoutsRepository;
    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;
    @Autowired
    private JpaFitnessCentersRepository fitnessCentersRepository;
    @Autowired
    private SearchClientService searchClientService;
    @Autowired
    private SearchAgeGroupService searchAgeGroupService;
    @Autowired
    private SearchFitnessCenterService searchFitnessCenterService;
    @Autowired
    private SearchWorkoutService searchWorkoutService;

    @GetMapping(value = "/memberCardRegistrationForm")
    public String showMemberCardFormFilling(ModelMap modelMap) {

        List<AgeGroup> ageGroups = ageGroupRepository.findAll();
        modelMap.addAttribute("ageGroups", ageGroups);

        List<Workout> workouts = workoutsRepository.findAll();
        modelMap.addAttribute("workouts", workouts);

        List<FitnessCenter> fitnessCenters = fitnessCentersRepository.findAll();
        modelMap.addAttribute("fitnessCenters", fitnessCenters);

        modelMap.addAttribute("request", new MemberCardRegistrationFormRequest());
        modelMap.addAttribute("searchRequest", new SearchMemberCardRequest());
        return "memberCardRegistrationForm";
    }

    @PostMapping("/memberCardFormFilling")
    public String processMemberCardFormFillingRequest(@ModelAttribute(value = "request") MemberCardRegistrationFormRequest request,
                                                      ModelMap modelMap) throws ParseException {
        MemberCardRegistrationFormResponse response = memberCardRegistrationService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "memberCardRegistrationForm";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/registeredWorkoutByClient/search")
    public String processSearchClientsRequest(@ModelAttribute(value = "searchRequest")
                                              SearchMemberCardRequest searchRequest,
                                              ModelMap modelMap) {
        SearchClientRequest searchClientRequest = new SearchClientRequest(
                searchRequest.getClientFirstName(), searchRequest.getClientLastName(), searchRequest.getClientPersonalCode());

        SearchClientResponse searchClientResponse = searchClientService.execute(searchClientRequest);
        modelMap.addAttribute("clients", searchClientResponse.getFoundClients());


        SearchWorkoutRequest searchWorkoutRequest = new SearchWorkoutRequest(
                searchRequest.getWorkoutTitle());

        SearchWorkoutResponse searchWorkoutResponse = searchWorkoutService.execute(searchWorkoutRequest);
        modelMap.addAttribute("workouts", searchWorkoutResponse.foundWorkouts());
        modelMap.addAttribute("request", new MemberCardRegistrationFormRequest());


        return "registeredWorkoutByClient";
    }



    /*

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetMemberCardResponse getMemberCard(@PathVariable Long id) {
        GetMemberCardRequest request = new GetMemberCardRequest(id);
        return getMemberCardService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public MemberCardRegistrationResponse addMemberCard(@RequestBody MemberCardRegistrationRequest request) {
        return addMemberCardService.execute(request);
    }

    @PostMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UpdateMemberCardResponse updateMemberCard(@RequestBody UpdateMemberCardRequest request) {
        return updateMemberCardService.execute(request);
    }


    // @DeleteMapping(path = "/{id}", produces = "application/json")
    //public DeleteMemberCardResponse deleteMemberCard(@PathVariable Long id) {
    //  DeleteMemberCardRequest request = new DeleteMemberCardRequest(id);
    //return deleteMemberCardService.executeByMemberCardId(request);
    // }

     */
}
