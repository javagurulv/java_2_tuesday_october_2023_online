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
class TravelCalculatePremiumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonFileReader jsonFileReader;


    @Test
    public void simpleRestControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest.json",
                "rest/TravelCalculatePremiumResponse.json"
        );
    }

    @Test
    public void firstNameIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_firstNameIsNull.json",
                "rest/TravelCalculatePremiumResponse_firstNameIsNull.json"
        );
    }

    @Test
    public void lastNameIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_lastNameIsNull.json",
                "rest/TravelCalculatePremiumResponse_lastNameIsNull.json"
        );
    }

    @Test
    public void dateFromIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateFromIsNull.json",
                "rest/TravelCalculatePremiumResponse_dateFromIsNull.json"
        );
    }

    @Test
    public void dateToIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateToIsNull.json",
                "rest/TravelCalculatePremiumResponse_dateToIsNull.json"
        );
    }

    @Test
    public void dateToLessDateFromControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateToLessDateFrom.json",
                "rest/TravelCalculatePremiumResponse_dateToLessDateFrom.json"
        );
    }

    @Test
    public void allFieldsIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_allFieldsIsNull.json",
                "rest/TravelCalculatePremiumResponse_allFieldsIsNull.json"
        );
    }

    @Test
    public void dateFromNotInFutureControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateFromNotInFuture.json",
                "rest/TravelCalculatePremiumResponse_dateFromNotInFuture.json"
        );
    }

    @Test
    public void dateToNotInFutureControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_dateToNotInFuture.json",
                "rest/TravelCalculatePremiumResponse_dateToNotInFuture.json"
        );
    }

    @Test
    public void selectedRiskIsNullControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selected_risk_null.json",
                "rest/TravelCalculatePremiumResponse_selected_risk_null.json"
        );
    }

    @Test
    public void selectedRiskIsEmptyControllerTest() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selected_risk_empty.json",
                "rest/TravelCalculatePremiumResponse_selected_risk_empty.json"
        );
    }

    @Test
    public void selectedRisksNotSupported() throws Exception {
        executeAndCompare(
                "rest/TravelCalculatePremiumRequest_selectedRisks_not_supported.json",
                "rest/TravelCalculatePremiumResponse_selectedRisks_not_supported.json"
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