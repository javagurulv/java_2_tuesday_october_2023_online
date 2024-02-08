package lv.javaguru.travel.insurance.core.services.entities;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.domain.entities.*;
import lv.javaguru.travel.insurance.core.repositories.entities.AgreementEntityRepository;
import lv.javaguru.travel.insurance.core.repositories.entities.AgreementPersonEntityRepository;
import lv.javaguru.travel.insurance.core.repositories.entities.AgreementPersonRiskEntityRepository;
import lv.javaguru.travel.insurance.core.repositories.entities.SelectedRiskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AgreementEntityFactory {
    @Autowired
    private AgreementEntityRepository agreementEntityRepository;

    @Autowired
    private SelectedRiskEntityRepository selectedRiskEntityRepository;

    @Autowired
    private AgreementPersonEntityRepository agreementPersonEntityRepository;

    @Autowired
    private AgreementPersonRiskEntityRepository agreementPersonRiskEntityRepository;

    @Autowired
    private PersonEntityFactory personEntityFactory;

    public AgreementEntity createAgreementEntity(AgreementDTO agreementDTO) {
        AgreementEntity agreementEntity = saveAgreement(agreementDTO);
        saveAllSelectedRisks(agreementDTO, agreementEntity);
        saveAllAgreementPersons(agreementDTO, agreementEntity);
        return agreementEntity;
    }

    //private void saveAllPersons(AgreementDTO agreement) {
    //      agreement.getPersons().forEach(personDTO -> personEntityFactory.createPersonEntity(personDTO));
    //  }

    private AgreementEntity saveAgreement(AgreementDTO agreementDTO) {
        AgreementEntity agreementEntity = new AgreementEntity();
        agreementEntity.setUuid(UUID.randomUUID().toString());
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

    private void saveAllAgreementPersons(AgreementDTO agreementDTO,
                                         AgreementEntity agreementEntity) {
        agreementDTO.getPersons().forEach(personDTO -> {
                    PersonEntity personEntity = personEntityFactory.createPersonEntity(personDTO);
                    AgreementPersonEntity agreementPersonEntity = saveAgreementPerson(agreementEntity, personDTO, personEntity);
                    saveAllAgreementPersonRisks(personDTO, agreementPersonEntity);
                }
        );
    }

    private AgreementPersonEntity saveAgreementPerson(AgreementEntity agreementEntity, PersonDTO personDTO, PersonEntity personEntity) {
        AgreementPersonEntity agreementPersonEntity = new AgreementPersonEntity();
        agreementPersonEntity.setAgreement(agreementEntity);
        agreementPersonEntity.setPerson(personEntity);
        agreementPersonEntity.setMedicalRiskLimitLevel(personDTO.getMedicalRiskLimitLevel());
        agreementPersonEntityRepository.save(agreementPersonEntity);
        return agreementPersonEntity;
    }

    private void saveAllAgreementPersonRisks(PersonDTO personDTO,
                                             AgreementPersonEntity agreementPerson) {
        personDTO.getRisks().forEach(riskDTO -> {
            AgreementPersonRiskEntity agreementPersonRiskEntity = new AgreementPersonRiskEntity();
            agreementPersonRiskEntity.setAgreementPerson(agreementPerson);
            agreementPersonRiskEntity.setRiskIc(riskDTO.getRiskIc());
            agreementPersonRiskEntity.setPremium(riskDTO.getPremium());
            agreementPersonRiskEntityRepository.save(agreementPersonRiskEntity);
        });
    }
}
