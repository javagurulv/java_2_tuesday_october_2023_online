package fitness_club;

import fitness_club.console_UI.*;
import fitness_club.core.database.Database;
import fitness_club.core.database.InFileDatabase;
import fitness_club.core.services.*;
import fitness_club.data_vlidation.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new InFileDatabase());
        beans.put(AddClientRequestValidator.class, new AddClientRequestValidator(getBean(Database.class)));
        beans.put(RemoveClientRequestValidator.class, new RemoveClientRequestValidator());
        beans.put(ChangeClientAgeGroupValidator.class, new ChangeClientAgeGroupValidator());
        beans.put(ChangeClientWorkoutsValidator.class, new ChangeClientWorkoutsValidator());
        beans.put(SearchClientRequestFieldValidator.class, new SearchClientRequestFieldValidator());
        beans.put(OrderingValidator.class, new OrderingValidator());
        beans.put(PagingValidator.class, new PagingValidator());
        beans.put(SearchClientRequestValidator.class, new SearchClientRequestValidator(
                getBean(SearchClientRequestFieldValidator.class),
                getBean(OrderingValidator.class),
                getBean(PagingValidator.class)
        ));

        beans.put(AddClientService.class, new AddClientService(
                getBean(Database.class),
                getBean(AddClientRequestValidator.class)
        ));
        beans.put(DeleteClientService.class, new DeleteClientService(
                getBean(Database.class),
                getBean(RemoveClientRequestValidator.class)
        ));
        beans.put(GetAllClientsService.class, new GetAllClientsService(
                getBean(Database.class)
        ));
        beans.put(ChangeClientAgeGroupService.class, new ChangeClientAgeGroupService(
                getBean(Database.class),
                getBean(ChangeClientAgeGroupValidator.class)
        ));
        beans.put(ChangeClientWorkoutService.class, new ChangeClientWorkoutService(
                getBean(Database.class),
                getBean(ChangeClientWorkoutsValidator.class)
        ));
        beans.put(SearchClientService.class, new SearchClientService(
                getBean(Database.class),
                getBean(SearchClientRequestValidator.class)
        ));

        beans.put(AddClientUIAction.class, new AddClientUIAction(getBean(AddClientService.class)));
        beans.put(RemoveClientUIAction.class, new RemoveClientUIAction(getBean(DeleteClientService.class)));
        beans.put(GetAllClientsUIAction.class, new GetAllClientsUIAction(getBean(GetAllClientsService.class)));
        beans.put(ChangeClientAgeGroupUIAction.class, new ChangeClientAgeGroupUIAction(getBean(ChangeClientAgeGroupService.class)));
        beans.put(ChangeWorkoutUIAction.class, new ChangeWorkoutUIAction(getBean(ChangeClientWorkoutService.class)));
        beans.put(SearchClientUIAction.class, new SearchClientUIAction(getBean(SearchClientService.class)));
        beans.put(ExitUIAction.class, new ExitUIAction());
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
