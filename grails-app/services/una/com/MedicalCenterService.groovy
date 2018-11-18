package una.com

import grails.gorm.services.Service

@Service(MedicalCenter)
interface MedicalCenterService {

    MedicalCenter get(Serializable id)

    List<MedicalCenter> list(Map args)

    Long count()

    void delete(Serializable id)

    MedicalCenter save(MedicalCenter medicalCenter)

}