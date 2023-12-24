package fitness_club.console_UI;


import fitness_club.core.requests.GetAllMemberCardsRequest;
import fitness_club.core.responses.GetAllMemberCardsResponse;
import fitness_club.core.services.GetAllMemberCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GetAllMemberCardsUIAction implements UIAction {

    @Autowired
    private GetAllMemberCardsService service;

    public void execute() {
        System.out.println("Member card list: ");
        GetAllMemberCardsRequest request = new GetAllMemberCardsRequest();
        GetAllMemberCardsResponse response = service.execute(request);
        response.getMemberCards().forEach(System.out::println);
        System.out.println("Member card list end.");
    }
}
