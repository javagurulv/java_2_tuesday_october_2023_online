package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.CoreError;
import avangardteen.java.request.ChangeAntropologDateRequest;
import avangardteen.java.responce.ChangeAntropologDateResponce;
import avangardteen.java.service.valigation.ChangeAntropologDateValidation;


import java.util.ArrayList;
import java.util.List;

public class ChangeAntropometricDataService {
    static Client user;
    ChangeAntropologDateValidation validator;

    public ChangeAntropometricDataService(ChangeAntropologDateValidation validator, Client user) {
        this.validator = validator;
        this.user = user;
    }

    public ChangeAntropologDateResponce responce(ChangeAntropologDateRequest request) {
        List<CoreError> errorList = new ArrayList<>();
        errorList = validator.errorlist(request);
        if(!errorList.isEmpty())
            return new ChangeAntropologDateResponce(errorList);
        switch (request.getNewChoose()) {
            case (1):
                user.getUserSizes().setPelvisWidth(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (2):
                user.getUserSizes().setThighLength(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (3):
                user.getUserSizes().setBackHeight(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
            case (4):

                user.getUserSizes().setShinLength(Integer.parseInt(request.getMeaning()));
                return new ChangeAntropologDateResponce();
        }
        return new ChangeAntropologDateResponce();

    }
}

