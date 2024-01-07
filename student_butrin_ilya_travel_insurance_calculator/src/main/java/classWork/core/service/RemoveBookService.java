package classWork.core.service;

import classWork.core.CoreError;
import classWork.core.database.BookRepository;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.valigators.RemoveBookValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RemoveBookService {

    @Autowired
    BookRepository data;
    @Autowired RemoveBookValidators validators;

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


