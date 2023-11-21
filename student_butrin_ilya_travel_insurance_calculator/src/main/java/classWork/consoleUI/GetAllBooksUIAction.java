package classWork.consoleUI;


import classWork.core.response.GetAllBookResponce;
import classWork.core.service.GetAllBookService;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

@DIComponent
public class GetAllBooksUIAction implements UIAction {
    @DIDependency GetAllBookService service;

    @Override
    public void execute() {
     GetAllBookResponce responce = service.execute();

    }
}

