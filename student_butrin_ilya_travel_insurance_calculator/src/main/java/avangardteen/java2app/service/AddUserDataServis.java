package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.UserSizes;
import avangardteen.java2app.Wheelchair;
import avangardteen.java2app.data.DataUsers;
import avangardteen.java2app.Client;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.AddPersonalDataRequest;
import avangardteen.java2app.responce.AddPersonalDateResponce;
import avangardteen.java2app.service.valigation.WheelchairValigator;
import java.util.List;
@Component public class AddUserDataServis {
  @Autowired DataUsers data;
   @Autowired UserSizes sizes;
   @Autowired Wheelchair wheelchair;
   @Autowired WheelchairValigator valigator;




    public AddPersonalDateResponce addUzer(AddPersonalDataRequest request) {
        List<CoreError> errors = valigator.errorlist(wheelchair);
        if (!errors.isEmpty())
            return new AddPersonalDateResponce(errors);
        else {
            Client user = new Client(wheelchair, sizes);
            user.setUserEmail(request.geteMail());
            user.setNameSurname(request.getNameSurname());
            user.setPhoneNumber(request.getPhoneNumber());
            data.addUser(user);
            return new AddPersonalDateResponce();
        }
    }



}
