package lv.javaguru.travel.insurance.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TravelCalculatePremiumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired private JsonFileReader jsonFileReader;
    private ObjectMapper mapper = new ObjectMapper();

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

        assertEquals(mapper.readTree(responseBodyContent), mapper.readTree(jsonResponse));
    }


}