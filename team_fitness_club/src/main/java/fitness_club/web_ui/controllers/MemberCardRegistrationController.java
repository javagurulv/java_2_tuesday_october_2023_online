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
public class MemberCardRegistrationController {

    @Autowired
    private MemberCardRegistrationService memberCardRegistrationService;
    @Autowired
    private JpaWorkoutsRepository workoutsRepository;
    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;
    @Autowired
    private JpaFitnessCentersRepository fitnessCentersRepository;
    @Autowired
    private SearchClientsService searchClientService;
    @Autowired
    private SearchAgeGroupService searchAgeGroupService;
    @Autowired
    private SearchFitnessCenterService searchFitnessCenterService;
    @Autowired
    private SearchWorkoutService searchWorkoutService;

    @GetMapping(value = "/memberCardRegistration")
    public String showMemberCardFilling(ModelMap modelMap) {

        modelMap.addAttribute("ageGroups", ageGroupRepository.findAll());

        modelMap.addAttribute("fitnessCenters", fitnessCentersRepository.findAll());

        modelMap.addAttribute("workouts", workoutsRepository.findAll());


        modelMap.addAttribute("request", new MemberCardRegistrationRequest());
        modelMap.addAttribute("searchRequest", new SearchMemberCardRequest());
        return "memberCardRegistration";
    }

    @PostMapping("/memberCardFormFilling")
    public String processMemberCardFillingRequest(@ModelAttribute(value = "request") MemberCardRegistrationRequest request,
                                                  ModelMap modelMap) throws ParseException {
        MemberCardRegistrationResponse response = memberCardRegistrationService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "memberCardRegistration";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/registeredWorkoutByClient/search")
    public String processSearchClientsRequest(@ModelAttribute(value = "searchRequest")
                                              SearchMemberCardRequest searchRequest,
                                              ModelMap modelMap) {
        SearchClientsRequest searchClientRequest = new SearchClientsRequest(
                searchRequest.getClientFirstName(), searchRequest.getClientLastName(), searchRequest.getClientPersonalCode());

        SearchClientsResponse searchClientResponse = searchClientService.execute(searchClientRequest);
        modelMap.addAttribute("clients", searchClientResponse.getFoundClients());


        SearchWorkoutRequest searchWorkoutRequest = new SearchWorkoutRequest(
                searchRequest.getWorkoutTitle());

        SearchWorkoutResponse searchWorkoutResponse = searchWorkoutService.execute(searchWorkoutRequest);
        modelMap.addAttribute("workouts", searchWorkoutResponse.foundWorkouts());
        modelMap.addAttribute("request", new MemberCardRegistrationRequest());


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