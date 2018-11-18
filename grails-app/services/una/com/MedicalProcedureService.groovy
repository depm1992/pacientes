package una.com

import grails.gorm.services.Service

@Service(MedicalProcedure)
interface MedicalProcedureService {

    MedicalProcedure get(Serializable id)

    List<MedicalProcedure> list(Map args)

    Long count()

    void delete(Serializable id)

    MedicalProcedure save(MedicalProcedure medicalProcedure)

}