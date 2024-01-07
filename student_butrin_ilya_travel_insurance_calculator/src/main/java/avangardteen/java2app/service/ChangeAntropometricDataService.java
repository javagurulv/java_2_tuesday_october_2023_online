package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.domen.UserSizes;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChangeAntropologDateRequest;
import avangardteen.java2app.responce.ChangeAntropologDateResponce;
import avangardteen.java2app.service.valigation.ChangeAntropologDateValigation;


import java.util.List;

@Component
public class ChangeAntropometricDataService {
 @Autowired UserSizes sizes;
 @Autowired Wheelchair wheelchair;
   @Autowired ChangeAntropologDateValigation valigator;


    public ChangeAntropologDateResponce responce(ChangeAntropologDateRequest request) {
        List<CoreError> errorList;
        errorList = valigator.errorlist(request);
        if(!errorList.isEmpty())
            return new ChangeAntropologDateResponce(errorList);
        switch (request.getNewChoose()) {
            case (1):
                sizes.setPelvisWidth(Integer.parseInt(request.getMeaning()));
                wheelchair.setSeatWidth(sizes.findSeatWidth());
                return new ChangeAntropologDateResponce();
            case (2):
                sizes.setThighLength(Integer.parseInt(request.getMeaning()));
                wheelchair.setSeatDepth(sizes.findSeatDepth());
                return new ChangeAntropologDateResponce();

            case (3):
                sizes.setBackHeight(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (4):
               sizes.setShinLength(Integer.parseInt(request.getMeaning()));
                wheelchair.setFootrestLength(sizes.findFootrestLength());
                return new ChangeAntropologDateResponce();
        }
        return new ChangeAntropologDateResponce();

    }
}

