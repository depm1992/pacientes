package una.com

import grails.gorm.services.Service

@Service(VisitProcedure)
interface VisitProcedureService {

    VisitProcedure get(Serializable id)

    List<VisitProcedure> list(Map args)

    Long count()

    void delete(Serializable id)

    VisitProcedure save(VisitProcedure visitProcedure)

}