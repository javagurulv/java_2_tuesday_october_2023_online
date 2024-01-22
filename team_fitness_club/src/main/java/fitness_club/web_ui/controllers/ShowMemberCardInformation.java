package fitness_club.web_ui.controllers;

import fitness_club.core.requests.GetMemberCardInformationRequest;
import fitness_club.core.responses.GetMemberCardInformationResponse;
import fitness_club.core.services.GetMemberCardInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ShowMemberCardInformation {
    @Autowired
    private GetMemberCardInformationService getMemberCardInformationService;

    @GetMapping(value = "/showMemberCardInformation")
    public String showAllReaderBooks(ModelMap modelMap) {
        GetMemberCardInformationResponse response = getMemberCardInformationService.execute(
                new GetMemberCardInformationRequest()
        );
        modelMap.addAttribute("memberCardInformation", response.getMemberCardInformation());
        return "/showMemberCardInformation";
    }
}
