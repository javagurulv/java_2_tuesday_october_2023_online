package classWork.core.service;

import classWork.core.CoreError;
import classWork.core.database.Database;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.valigators.RemoveBookValidators;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

import java.util.List;


@DIComponent
public class RemoveBookService {

    @DIDependency Database data;
    @DIDependency RemoveBookValidators validators;

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


