package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.api.comamnd.TravelExportAgreementToXmlCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelExportAgreementToXmlCoreResult;


public interface TravelExportAgreementToXmlService {
    TravelExportAgreementToXmlCoreResult export(TravelExportAgreementToXmlCoreCommand command);
}
