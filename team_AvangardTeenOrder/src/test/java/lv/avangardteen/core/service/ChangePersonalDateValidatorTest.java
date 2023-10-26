package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChangePersonalDateValidatorTest {

    private ChangePersonalDateValidator validator = new ChangePersonalDateValidator();

/*

    TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
    Date date1 = dates.parse("01.11.2023");
    Date date2 = dates.parse("02.11.2023");
    when(request.getPersonFirstName()).thenReturn(null);
    when(request.getPersonLastName()).thenReturn("lastName");
    when(request.getAgreementDateFrom()).thenReturn(date1);
    when(request.getAgreementDateTo()).thenReturn(date2);
    List<ValidationError> errors = requestValidator.validate(request);
    assertFalse(errors.isEmpty());
    assertEquals(errors.size(), 1);
    assertEquals(errors.get(0).getField(), "personFirstName");
    assertEquals(errors.get(0).getMessage(), "Must not be empty!");*/

/*

    @Test
    public void testGetId() {
        ChangePersonalDateRequest request =  mock(ChangePersonalDateRequest.class);
        when(request.getId()).thenReturn(0);
        when(request.getNameSurname()).thenReturn("nameSurname");
        when(request.getPhoneNumber()).thenReturn("88888888");
        when(request.getUserAddress()).thenReturn( "Lesnaja 67");
        List<CoreError> validList = validator.validate(request);
        assertFalse(validList.isEmpty());
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Must not be empty!" );


    }
*/

    @Test
    public void testSurnameNull() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(44444, null, 22222222,
                "Lesnaja 67");
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("nameSurname", "Must not be empty!")));

    }



    @Test
    public void testAddressNull() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(44444, "Ivan Ivanov", 22222222,
                null);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("userAddress", "Must not be empty!")));

    }

    @Test
    public void testAddressEmpty() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(44444, "Ivan Ivanov", 22222222,
                "");
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("userAddress", "Must not be empty!")));

    }

    @Test
    public void testId() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(0, "Ivan Ivanov", 22222222,
                "Lesnaja 67");
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("idClient", "Must not be empty!")));

    }

    @Test
    public void testPhone() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(44444, "Ivan",
                0,
                "Lesnaja 67");
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("phoneNumber", "Must contain only numbers!")));

    }


}