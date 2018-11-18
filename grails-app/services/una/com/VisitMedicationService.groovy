package una.com

import grails.gorm.services.Service

@Service(VisitMedication)
interface VisitMedicationService {

    VisitMedication get(Serializable id)

    List<VisitMedication> list(Map args)

    Long count()

    void delete(Serializable id)

    VisitMedication save(VisitMedication visitMedication)

}