package avangardteen.java.service;

import avangardteen.java.CoreError;
import avangardteen.java.UserSizes;
import avangardteen.java.Wheelchair;
import avangardteen.java.data.DataUsers;
import avangardteen.java.Client;

import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;
import avangardteen.java.request.AddPersonalDataRequest;
import avangardteen.java.responce.AddPersonalDateResponce;
import avangardteen.java.service.valigation.WheelchairValigator;
import java.util.List;
@DIComponent public class AddUserDataServis {
  @DIDependency DataUsers data;
   @DIDependency UserSizes sizes;
   @DIDependency Wheelchair wheelchair;
   @DIDependency WheelchairValigator valigator;




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
