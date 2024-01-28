package classWork.consoleUI;


import classWork.core.CoreError;
import classWork.core.requests.AddBookRequest;
import classWork.core.response.AddBookResponse;
import classWork.core.service.AddBookService;
//import classWork.dependency_injection.DIComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class AddBookUIAction implements UIAction {
    @Autowired AddBookService addBookService;

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите автора");
        String author = scan.nextLine();
        System.out.println("Введите название книги");
        String title = scan.nextLine();
        AddBookRequest request = new AddBookRequest(title, author);
        AddBookResponse response = addBookService.execute(request);

       if (response.hasErrors()){
            List<CoreError>errorList = response.getErrors();
            for(CoreError error:errorList)
                System.err.println("ОШИБКА: " + error.getField() + error.getMessage());
        }
        else System.out.println("Книга добавлена");




        }
    }
