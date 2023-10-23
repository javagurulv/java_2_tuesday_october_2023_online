package classWork.core.service;

import classWork.Database;
import classWork.core.CoreError;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.valigators.RemoveBookValidators;

import java.util.List;



public class RemoveBookService {
    Database data;
    RemoveBookValidators validators;

    public RemoveBookService(Database data, RemoveBookValidators validators) {
        this.data = data;
        this.validators = validators;
    }

    public RemoveBookResponce execute (RemoveBookReques reques) {
        List<CoreError> errorList = validators.errorList(reques);
        if (!errorList.isEmpty()) {
            RemoveBookResponce respWithError = new RemoveBookResponce(errorList);
            return  respWithError;
        }
        boolean bol = data.deleteBook(reques.getId());
        return new RemoveBookResponce(bol);
        }

    }


