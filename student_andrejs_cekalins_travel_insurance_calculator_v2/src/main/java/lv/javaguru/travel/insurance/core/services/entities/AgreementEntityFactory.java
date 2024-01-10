package lv.javaguru.travel.insurance.core.services.entities;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.domain.entities.AgreementEntity;
import lv.javaguru.travel.insurance.core.domain.entities.SelectedRisksEntity;
import lv.javaguru.travel.insurance.core.repositories.entities.AgreementEntityRepository;
import lv.javaguru.travel.insurance.core.repositories.entities.SelectedRiskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgreementEntityFactory {
    @Autowired
    private AgreementEntityRepository agreementEntityRepository;

    @Autowired
    private SelectedRiskEntityRepository selectedRiskEntityRepository;

    @Autowired
    private PersonEntityFactory personEntityFactory;

    public AgreementEntity createAgreementEntity(AgreementDTO agreementDTO) {
        saveAllPersons(agreementDTO);
        AgreementEntity agreementEntity = saveAgreement(agreementDTO);
        saveAllSelectedRisks(agreementDTO, agreementEntity);
        return agreementEntity;
    }

    private void saveAllPersons(AgreementDTO agreement) {
        agreement.getPersons().forEach(personDTO -> personEntityFactory.createPersonEntity(personDTO));
    }

    private AgreementEntity saveAgreement(AgreementDTO agreementDTO) {
        AgreementEntity agreementEntity = new AgreementEntity();
        agreementEntity.setAgreementDateFrom(agreementDTO.getAgreementDateFrom());
        agreementEntity.setAgreementDateTo(agreementDTO.getAgreementDateTo());
        agreementEntity.setCountry(agreementDTO.getCountry());
        agreementEntity.setAgreementPremium(agreementDTO.getAgreementPremium());
        return agreementEntityRepository.save(agreementEntity);
    }

    private void saveAllSelectedRisks(AgreementDTO agreementDTO,
                                      AgreementEntity agreementEntity) {
        agreementDTO.getSelectedRisk().forEach(riscIc -> {
            SelectedRisksEntity risksEntity = new SelectedRisksEntity();
            risksEntity.setAgreement(agreementEntity);
            risksEntity.setRiskIc(riscIc);
            selectedRiskEntityRepository.save(risksEntity);
        });
    }
}
