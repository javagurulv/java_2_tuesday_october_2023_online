package fitness_club.web_ui.controllers;

import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.SearchClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchClientController {

    @Autowired private SearchClientService searchClientService;

    @GetMapping(value = "/searchClient")
    public String showSearchClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchClientRequest());
        return "searchClient";
    }
    @PostMapping("/searchClient")
    public String processSearchClientRequest(@ModelAttribute(value = "request") SearchClientRequest request, ModelMap modelMap) {
        SearchClientResponse response = searchClientService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "searchClient";
        } else {
            return "index";
        }
    }

}
