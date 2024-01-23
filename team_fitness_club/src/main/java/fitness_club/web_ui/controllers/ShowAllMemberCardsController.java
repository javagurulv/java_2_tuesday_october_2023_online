package fitness_club.web_ui.controllers;

import fitness_club.core.requests.GetAllMemberCardsRequest;
import fitness_club.core.responses.GetAllMemberCardsResponse;
import fitness_club.core.services.GetAllMemberCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ShowAllMemberCardsController {
    @Autowired
    private GetAllMemberCardsService getAllMemberCardsService;

    @GetMapping(value = "/showAllMemberCards")
    public String showAllMemberCards(ModelMap modelMap) {
        GetAllMemberCardsResponse response = getAllMemberCardsService.execute(
                new GetAllMemberCardsRequest()
        );
        modelMap.addAttribute("memberCard", response.getMemberCards());
        return "/showAllMemberCards";
    }
}
