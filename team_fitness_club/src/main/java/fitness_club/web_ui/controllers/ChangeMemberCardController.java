package fitness_club.web_ui.controllers;

import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaFitnessCentersRepository;
import fitness_club.core.database.jpa.JpaWorkoutsRepository;
import fitness_club.core.requests.UpdateMemberCardRequest;
import fitness_club.core.responses.UpdateMemberCardResponse;
import fitness_club.core.services.SearchAgeGroupService;
import fitness_club.core.services.SearchFitnessCenterService;
import fitness_club.core.services.SearchWorkoutService;
import fitness_club.core.services.UpdateMemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;

@Controller
public class ChangeMemberCardController {

    @Autowired
    private UpdateMemberCardService updateMemberCardService;
    @Autowired
    private JpaWorkoutsRepository workoutsRepository;
    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;
    @Autowired
    private JpaFitnessCentersRepository fitnessCentersRepository;
    @Autowired
    private SearchAgeGroupService searchAgeGroupService;
    @Autowired
    private SearchFitnessCenterService searchFitnessCenterService;
    @Autowired
    private SearchWorkoutService searchWorkoutService;

    @GetMapping(value = "/changeMemberCard")
    public String showMemberCardFilling(ModelMap modelMap) {

        modelMap.addAttribute("ageGroups", ageGroupRepository.findAll());

        modelMap.addAttribute("fitnessCenters", fitnessCentersRepository.findAll());

        modelMap.addAttribute("workouts", workoutsRepository.findAll());

        modelMap.addAttribute("request", new UpdateMemberCardRequest());
        return "changeMemberCard";
    }

    @PostMapping("/updateMemberCardForm")
    public String processMemberCardUpdateRequest(@ModelAttribute(value = "request") UpdateMemberCardRequest request,
                                                 ModelMap modelMap) throws ParseException {
        UpdateMemberCardResponse response = updateMemberCardService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "changeMemberCard";
        } else {
            return "redirect:/";
        }
    }
}
