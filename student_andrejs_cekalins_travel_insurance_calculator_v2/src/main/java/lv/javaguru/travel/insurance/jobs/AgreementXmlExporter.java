package lv.javaguru.travel.insurance.jobs;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelExportAgreementToXmlCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreCommand;
import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.services.TravelExportAgreementToXmlService;
import lv.javaguru.travel.insurance.core.services.TravelGetAgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AgreementXmlExporter {
    private static final Logger logger = LoggerFactory.getLogger(AgreementXmlExporterJob.class);


    private final TravelExportAgreementToXmlService agreementToXmlService;


    public void exportAgreement(String agreementUuid) {
        logger.info("AgreementXmlExporterJob started for uuid = " + agreementUuid);
        agreementToXmlService.export(new TravelExportAgreementToXmlCoreCommand(agreementUuid));
        logger.info("AgreementXmlExporterJob finished for uuid = " + agreementUuid);

    }

}
