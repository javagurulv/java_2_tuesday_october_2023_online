package fitness_club.web_ui.controllers.rest;

import fitness_club.core.requests.*;
import fitness_club.core.responses.*;
import fitness_club.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class MemberCardRestController {

    @Autowired
    private GetMemberCardService getMemberCardService;
    @Autowired
    private AddMemberCardService addMemberCardService;
    @Autowired
    private UpdateMemberCardService updateMemberCardService;


    @GetMapping(path = "/{id}", produces = "application/json")
    public GetMemberCardResponse getMemberCard(@PathVariable Long id) {
        GetMemberCardRequest request = new GetMemberCardRequest(id);
        return getMemberCardService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddMemberCardResponse addMemberCard(@RequestBody AddMemberCardRequest request) {
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
}
