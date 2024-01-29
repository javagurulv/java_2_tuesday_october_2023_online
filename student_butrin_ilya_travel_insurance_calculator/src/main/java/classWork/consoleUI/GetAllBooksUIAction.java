package classWork.consoleUI;


import classWork.core.response.GetAllBookResponce;
import classWork.core.service.GetAllBookService;
//import classWork.dependency_injection.DIComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllBooksUIAction implements UIAction {
    @Autowired GetAllBookService service;

    @Override
    public void execute() {
     GetAllBookResponce responce = service.execute();

    }
}

