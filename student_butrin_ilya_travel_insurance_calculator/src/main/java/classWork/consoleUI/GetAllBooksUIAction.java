package classWork.consoleUI;


import classWork.core.response.GetAllBookResponce;
import classWork.core.service.GetAllBookService;

public class GetAllBooksUIAction implements UIAction {

    public GetAllBooksUIAction(GetAllBookService service) {
        this.service = service;
    }

    GetAllBookService service;

    @Override
    public void execute() {
     GetAllBookResponce responce = service.execute();

    }
}

