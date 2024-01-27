package lv.avangardteen.web_ui.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ComponentRegistrationRequestLogger {
    private static final Logger logger = LoggerFactory.getLogger(ComponentRegistrationRequestLogger.class);

    void setLogger(ComponentRegistrationRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(request);
            logger.info("REQUEST: " + json);
        } catch (JsonProcessingException e) {
            logger.error("Error to convert request to JSON", e);
        }
    }
}
