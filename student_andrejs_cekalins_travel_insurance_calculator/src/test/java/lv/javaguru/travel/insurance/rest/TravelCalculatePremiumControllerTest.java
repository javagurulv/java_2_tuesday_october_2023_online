package lv.javaguru.travel.insurance.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelCalculatePremiumControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonFileReader jsonFileReader;

    @Test
    public void successRequestTravelMedical() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_travel_medical_success.json",
                "rest/TravelCalculatePremiumResponse_travel_medical_success.json"
        );
    }

    @Test
    public void personFirstNameIsEmpty() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_firstName_is_empty.json",
                "rest/TravelCalculatePremiumResponse_firstName_is_empty.json"
        );
    }

    @Test
    public void personFirstNameIsNull() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_firstName_is_null.json",
                "rest/TravelCalculatePremiumResponse_firstName_is_null.json"
        );
    }

    @Test
    public void lastNameIsEmpty() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_lastName_is_empty.json",
                "rest/TravelCalculatePremiumResponse_lastName_is_empty.json"
        );
    }

    @Test
    public void lastNameIsNull() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_lastName_is_null.json",
                "rest/TravelCalculatePremiumResponse_lastName_is_null.json"
        );
    }

    @Test
    public void allFieldsNotProvided() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_allFields_not_provided.json",
                "rest/TravelCalculatePremiumResponse_allFields_not_provided.json"
        );
    }

    @Test
    public void dateFromNotProvided() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateFrom_not_provided.json",
                "rest/TravelCalculatePremiumResponse_dateFrom_not_provided.json"
        );
    }

    @Test
    public void dateToNotProvided() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateTo_not_provided.json",
                "rest/TravelCalculatePremiumResponse_dateTo_not_provided.json"
        );
    }

    @Test
    public void agreementDateToLessThenAgreementDateFrom() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateTo_less_then_dateFrom.json",
                "rest/TravelCalculatePremiumResponse_dateTo_less_then_dateFrom.json"
        );

    }

    @Test
    public void agreementDateFromInThePast() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateFrom_In_The_Past.json",
                "rest/TravelCalculatePremiumResponse_dateFrom_In_The_Past.json"
        );
    }

    @Test
    public void agreementDateToInThePast() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateTo_In_The_Past.json",
                "rest/TravelCalculatePremiumResponse_dateTo_In_The_Past.json"
        );
    }

    @Test
    public void selectedRiskValidationEmpty() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selected_risk_empty.json",
                "rest/TravelCalculatePremiumResponse_selected_risk_empty.json"
        );
    }

    @Test
    public void selectedRiskValidationNull() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selected_risk_null.json",
                "rest/TravelCalculatePremiumResponse_selected_risk_null.json"
        );
    }

    @Test
    public void selectedRisksNotSupported() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selectedRisks_not_supported.json",
                "rest/TravelCalculatePremiumResponse_selectedRisks_not_supported.json"
        );
    }

    @Test
    public void countryIsNullWhenTravelMedicalRiskSelected() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_country_is_null_travel_medical.json",
                "rest/TravelCalculatePremiumResponse_country_is_null_travel_medical.json"
        );
    }
    @Test
    public void countryIsEmptyWhenTravelMedicalRiskSelected() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_country_is_empty_travel_medical.json",
                "rest/TravelCalculatePremiumResponse_country_is_empty_travel_medical.json"
        );
    }

    private void executeAndCompare(String jsonRequestFilePath,
                                   String jsonResponseFilePath) throws Exception {
        String jsonRequest = jsonFileReader.readJsonFromFile(jsonRequestFilePath);

        MvcResult result = mockMvc.perform(post("/insurance/travel/")
                        .content(jsonRequest)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        String jsonResponse = jsonFileReader.readJsonFromFile(jsonResponseFilePath);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }

}