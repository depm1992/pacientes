package una.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VisitProcedureServiceSpec extends Specification {

    VisitProcedureService visitProcedureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VisitProcedure(...).save(flush: true, failOnError: true)
        //new VisitProcedure(...).save(flush: true, failOnError: true)
        //VisitProcedure visitProcedure = new VisitProcedure(...).save(flush: true, failOnError: true)
        //new VisitProcedure(...).save(flush: true, failOnError: true)
        //new VisitProcedure(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //visitProcedure.id
    }

    void "test get"() {
        setupData()

        expect:
        visitProcedureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VisitProcedure> visitProcedureList = visitProcedureService.list(max: 2, offset: 2)

        then:
        visitProcedureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        visitProcedureService.count() == 5
    }

    void "test delete"() {
        Long visitProcedureId = setupData()

        expect:
        visitProcedureService.count() == 5

        when:
        visitProcedureService.delete(visitProcedureId)
        sessionFactory.currentSession.flush()

        then:
        visitProcedureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VisitProcedure visitProcedure = new VisitProcedure()
        visitProcedureService.save(visitProcedure)

        then:
        visitProcedure.id != null
    }
}
