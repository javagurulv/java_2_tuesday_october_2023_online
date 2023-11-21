package classWork.consoleUI;


import classWork.core.CoreError;
import classWork.core.requests.AddBookRequest;
import classWork.core.response.AddBookResponse;
import classWork.core.service.AddBookService;

import java.util.List;
import java.util.Scanner;

public class AddBookUIAction implements UIAction {
    AddBookService addBookService;

    public AddBookUIAction(AddBookService addBookService) {
        this.addBookService = addBookService;
    }

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
