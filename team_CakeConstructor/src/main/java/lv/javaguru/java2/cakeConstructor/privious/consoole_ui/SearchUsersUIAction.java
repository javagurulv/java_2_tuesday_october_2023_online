package lv.javaguru.java2.cakeConstructor.privious.consoole_ui;

import lv.javaguru.java2.cakeConstructor.privious.cake.request.SearchUserRequest;
import lv.javaguru.java2.cakeConstructor.privious.cake.responses.SearchUserResponse;
import lv.javaguru.java2.cakeConstructor.privious.cake.services.SearchUserService;

import java.util.Scanner;

public class SearchUsersUIAction  implements  UIAction {

    private SearchUserService searchUserService;

    public SearchUsersUIAction(SearchUserService searchUserService) {
        this.searchUserService = searchUserService;
    }

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
        SearchUserResponse response = searchUserService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getUsers().forEach(System.out::println);
        }
    }
}
