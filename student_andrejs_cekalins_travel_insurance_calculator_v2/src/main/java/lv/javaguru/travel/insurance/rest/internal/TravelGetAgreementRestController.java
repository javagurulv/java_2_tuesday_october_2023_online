package lv.javaguru.travel.insurance.rest.internal;

import com.google.common.base.Stopwatch;

import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreResult;
import lv.javaguru.travel.insurance.core.services.TravelGetAgreementService;
import lv.javaguru.travel.insurance.dto.internal.GetAgreementDtoConverter;
import lv.javaguru.travel.insurance.dto.internal.TravelGetAgreementResponse;
import lv.javaguru.travel.insurance.rest.common.TravelCalculatePremiumRequestExecutionTimeLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/insurance/travel/api/internal/agreement")
public class TravelGetAgreementRestController {

    @Autowired
    private TravelGetAgreementRequestLogger requestLogger;
    @Autowired
    private TravelGetAgreementResponseLogger responseLogger;
    @Autowired
    private TravelCalculatePremiumRequestExecutionTimeLogger executionTimeLogger;
    @Autowired
    private TravelGetAgreementService getAgreementService;
    @Autowired
    private GetAgreementDtoConverter dtoConverter;

    @GetMapping(path = "/{uuid}",
            produces = "application/json")
    public TravelGetAgreementResponse getAgreement(@PathVariable String uuid) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TravelGetAgreementResponse response = processRequest(uuid);
        executionTimeLogger.logExecutionTime(stopwatch);
        return response;
    }

    private TravelGetAgreementResponse processRequest(String uuid) {
        requestLogger.log(uuid);

        TravelGetAgreementCoreCommand coreCommand = dtoConverter.buildCoreCommand(uuid);
        TravelGetAgreementCoreResult coreResult= getAgreementService.getAgreement(coreCommand);
        TravelGetAgreementResponse response = dtoConverter.buildResponse(coreResult);

        responseLogger.log(response);
        return response;
    }

}