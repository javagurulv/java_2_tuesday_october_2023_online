package lv.avangardteen.core.service.validate;
/*



import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {OrderListConfiguration.class})
@Sql({"/schema.sql"})
class OrderValidatorTest {

   @Autowired
   private Database database;
@Autowired
    private OrderValidator validator;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void getResponseWithErrorsClientNotFound() {
        Client client = new Client("Petrov", 111L, 222L, "vvv");
        database.addUser(client);
        OrderRequest request = new OrderRequest("Ivanov", 111L, 22, 22, 22, 22);
Client client1 = database.findBySurnameAndPersonalCode("Ivanov", 111L);
System.out.println(client1);
      */
/*  List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
       assertEquals(errors, List.of(new CoreError("clientAbsent", "Client must be registered!")));*//*

    }

    @Test
    public void getResponseWithErrorsParameter1IsNull() {
        Client client = new Client("Petrov", 111L, 222L, "vvv");
        database.addUser(client);
        OrderRequest request = new OrderRequest("Petrov", 111L, null, 22, 22, 22);

        List<CoreError> errors = validator.validate(request);
        assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!")));
    }


    @Test
    public void getResponseWithErrorsParameter2IsNull() {
        Client client = new Client("Petrov", 111L, 222L, "vvv");
        database.addUser(client);
        OrderRequest request = new OrderRequest("Petrov", 111L, 22, null, 22, 22);

        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);

         assertEquals(errors, List.of(new CoreError("thighLength", "Must not be empty!")));
    }


}
*/

