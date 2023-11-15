package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.CoreError;
import avangardteen.java.UserSizes;
import avangardteen.java.request.ChangeAntropologDateRequest;
import avangardteen.java.responce.ChangeAntropologDateResponce;
import avangardteen.java.service.valigation.ChangeAntropologDateValigation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeAntropometricDataService {
    UserSizes sizes;
    ChangeAntropologDateValigation valigator;

    public ChangeAntropometricDataService(UserSizes sizes, ChangeAntropologDateValigation valigator) {
        this.sizes = sizes;
        this.valigator = valigator;
    }

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

