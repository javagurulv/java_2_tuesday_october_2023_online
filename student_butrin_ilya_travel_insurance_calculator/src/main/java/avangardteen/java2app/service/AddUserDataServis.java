package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.domen.UserSizes;
import avangardteen.java2app.domen.Wheelchair;;
import avangardteen.java2app.domen.Client;

import avangardteen.java2app.data.DatabaseClient;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.AddPersonalDataRequest;
import avangardteen.java2app.responce.AddPersonalDateResponce;
import avangardteen.java2app.service.valigation.WheelchairValigator;
import java.util.List;
@Component public class AddUserDataServis {
  @Autowired
  DatabaseClient data;
//   @Autowired UserSizes sizes;
   @Autowired Wheelchair wheelchair;
   @Autowired WheelchairValigator valigator;




    public AddPersonalDateResponce addUzer(AddPersonalDataRequest request) {
        List<CoreError> errors = valigator.errorlist(wheelchair);
        if (!errors.isEmpty())
            return new AddPersonalDateResponce(errors);
        else {
            Client client = new Client();
            client.setFirstName(request.getFirstName());
            client.setLastName(request.getSecondName());
            client.setUserEmail(request.geteMail());
            client.setFirstName(request.getFirstName());
            client.setPhoneNumber(request.getPhoneNumber());
            data.addClient(client);
            return new AddPersonalDateResponce();
        }
    }



}
