package classWork.consoleUI;

import classWork.core.CoreError;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.RemoveBookService;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

import java.util.List;
import java.util.Scanner;
@DIComponent
public class RemoveBookUIAction implements UIAction {
    @DIDependency RemoveBookService service;
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер книги, который хотите удалить");
        String del = scan.nextLine();
        Long delById;
        if(!del.isEmpty()) delById = Long.parseLong(del);
        else delById = 0L;
        RemoveBookReques reques = new RemoveBookReques(delById);
        RemoveBookResponce response = service.execute(reques);

        if(response.hasErrors())
        { List<CoreError> errorList = response.getErrors();
            for (CoreError err : errorList){
             System.err.println("ОШИБКА: " + err.getField() + err.getMessage());
            }
        }
        else
            System.out.println("Книга удалена");


    }
}

