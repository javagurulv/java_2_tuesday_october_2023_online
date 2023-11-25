package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.UserSizes;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.ChangeAntropologDateRequest;
import avangardteen.java2app.responce.ChangeAntropologDateResponce;
import avangardteen.java2app.service.valigation.ChangeAntropologDateValigation;


import java.util.List;

@DIComponent
public class ChangeAntropometricDataService {
 @DIDependency UserSizes sizes;
   @DIDependency ChangeAntropologDateValigation valigator;


    public ChangeAntropologDateResponce responce(ChangeAntropologDateRequest request) {
        List<CoreError> errorList;
        errorList = valigator.errorlist(request);
        if(!errorList.isEmpty())
            return new ChangeAntropologDateResponce(errorList);
        switch (request.getNewChoose()) {
            case (1):
                sizes.setPelvisWidth(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (2):
                sizes.setThighLength(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (3):
                sizes.setBackHeight(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (4):

               sizes.setShinLength(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
        }
        return new ChangeAntropologDateResponce();

    }
}

