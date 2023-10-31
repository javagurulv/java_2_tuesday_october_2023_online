package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.core.cake.request.SearchUserRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.SearchUserResponse;

import java.util.Scanner;

public class SearchUsersUIAction  implements  UIAction {
    @Override
    public void execute(String clientLogin) {

    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String login = scanner.nextLine();
        System.out.println("Enter book author: ");
        String userName = scanner.nextLine();

        SearchUserRequest request = new SearchUserRequest (login,userName);
        SearchUserResponse response = SearchUserService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getUsers().forEach(System.out::println);
        }
    }
}
