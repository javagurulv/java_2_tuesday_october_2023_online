package lv.javaguru.java2.cakeConstructor.core.cake.services;

import lv.javaguru.java2.cakeConstructor.core.cake.database.DateBaseIf;
import lv.javaguru.java2.cakeConstructor.core.cake.request.SearchUserRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.CoreError;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.SearchUserResponse;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.util.List;

public class SearchUserService {
    private DateBaseIf dateBase;
    private SearchUserRequestValidation validation;

    public SearchUserService (DateBaseIf dateBase, SearchUserRequestValidation validation){
        this.dateBase=dateBase;
        this.validation=validation;

    }
    public SearchUserResponse execute(SearchUserRequest request) {
        List<CoreError> errors = validation.validate(request);
        if (!errors.isEmpty()) {
            return new SearchUserResponse(null, errors);
        }

        List<User> users = null;
        if (request.isLoginProvided()&& !request.isUserNameProvided()) {

        }
        if (!request.isLoginProvided() && request.isUserNameProvided()) {

        }
        if (request.isLoginProvided() && request.isUserNameProvided()) {

        }

        return new SearchUserResponse(users, null);
    }
}
