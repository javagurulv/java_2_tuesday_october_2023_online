package lv.avangardteen.web_ui.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.avangardteen.core.responce.GetClientResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GetClientResponseLogger {
    private static final Logger logger = LoggerFactory.getLogger(GetClientResponseLogger.class);

    void setLogger(GetClientResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(response);
            logger.info("RESPONSE: " + json);
        } catch (JsonProcessingException e) {
            logger.error("Error to convert response to JSON", e);
        }
    }
}
