package fitness_club.core.services;

import fitness_club.core.database.jpa.*;
import fitness_club.core.domain.*;
import fitness_club.core.requests.MemberCardRegistrationRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.MemberCardRegistrationResponse;
import fitness_club.core.services.validators.memberCard.MemberCardRegistrationRequestValidator;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MemberCardRegistrationServiceTest {


    @Mock
    private MemberCardRegistrationRequestValidator validator;
    @InjectMocks
    private MemberCardRegistrationService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() throws ParseException {


        MemberCardRegistrationRequest notValidRequest = new MemberCardRegistrationRequest(null, 1L, 2L, 1L, "2024.04.28");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode",
                "Field client personal code must not be empty!")));
        MemberCardRegistrationResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidator() throws ParseException {

        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L,
                createDate("2024.04.28"));

        MemberCardRegistrationRequest notValidRequest = new MemberCardRegistrationRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode",
                "Field client ID must not be empty!")));
        MemberCardRegistrationResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Field client ID must not be empty!");
    }


    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}