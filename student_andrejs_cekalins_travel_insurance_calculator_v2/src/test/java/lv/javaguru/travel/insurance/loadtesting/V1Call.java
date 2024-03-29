package lv.javaguru.travel.insurance.loadtesting;

import com.google.common.base.Stopwatch;
import lv.javaguru.travel.insurance.rest.common.JsonFileReader;

public class V1Call extends CommonCall implements  Runnable {

    private static final String CALCULATE_PREMIUM_V1_LOCAL_URL = "http://localhost:8080/insurance/travel/api/v1/";
    private String jsonRequest;
    private String jsonResponse;
    private LoadTestingStatistic statistic;

    private Stopwatch stopwatch;

    public V1Call(LoadTestingStatistic statistic) {
        this.statistic = statistic;
        JsonFileReader jsonFileReader = new JsonFileReader();
        jsonRequest = jsonFileReader.readJsonFromFile("rest/v1/risk_travel_medical/Success_case_with_TRAVEL_MEDICAL_risk_only/request.json");
        jsonResponse = jsonFileReader.readJsonFromFile("rest/v1/risk_travel_medical/Success_case_with_TRAVEL_MEDICAL_risk_only/response.json");
        stopwatch = Stopwatch.createStarted();
    }

    @Override
    public void run() {
        executeRestCallAndCompareResults(jsonRequest, jsonResponse, CALCULATE_PREMIUM_V1_LOCAL_URL);
        stopwatch.stop();
        long elapsedMillis = stopwatch.elapsed().toMillis();
        System.out.println("Request processing time (ms): " + elapsedMillis);
        statistic.addExecutionTime(elapsedMillis);
    }
}
