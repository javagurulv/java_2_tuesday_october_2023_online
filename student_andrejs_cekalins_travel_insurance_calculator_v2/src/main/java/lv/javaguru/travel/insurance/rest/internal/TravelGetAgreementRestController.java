package lv.javaguru.travel.insurance.rest.internal;

import com.google.common.base.Stopwatch;

import lv.javaguru.travel.insurance.dto.internal.TravelGetAgreementResponse;
import lv.javaguru.travel.insurance.rest.common.TravelCalculatePremiumRequestExecutionTimeLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/insurance/travel/api/internal/agreement")
public class TravelGetAgreementRestController {

    @Autowired private TravelGetAgreementRequestLogger requestLogger;
    @Autowired private TravelGetAgreementResponseLogger responseLogger;
    @Autowired private TravelCalculatePremiumRequestExecutionTimeLogger executionTimeLogger;

   @GetMapping (path = "/{uuid}",
   produces = "application/json")
    public TravelGetAgreementResponse getAgreement(@PathVariable String uuid) {
       Stopwatch stopwatch = Stopwatch.createStarted();
       TravelGetAgreementResponse response = processRequest(uuid);
       new TravelGetAgreementResponse();
       response.setAgreementDateFrom(new Date());
       response.setAgreementDateTo(new Date());
       response.setUuid(uuid);
       executionTimeLogger.logExecutionTime(stopwatch);
       return response;
   }

   private TravelGetAgreementResponse processRequest(String uuid) {
       requestLogger.log(uuid);

      TravelGetAgreementResponse response  = new TravelGetAgreementResponse();
       response.setAgreementDateFrom(new Date());
       response.setAgreementDateTo(new Date());
       response.setUuid(uuid);

       responseLogger.log(response);
       return response;
   }

}