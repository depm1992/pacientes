package una.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VisitMedicationServiceSpec extends Specification {

    VisitMedicationService visitMedicationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VisitMedication(...).save(flush: true, failOnError: true)
        //new VisitMedication(...).save(flush: true, failOnError: true)
        //VisitMedication visitMedication = new VisitMedication(...).save(flush: true, failOnError: true)
        //new VisitMedication(...).save(flush: true, failOnError: true)
        //new VisitMedication(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //visitMedication.id
    }

    void "test get"() {
        setupData()

        expect:
        visitMedicationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VisitMedication> visitMedicationList = visitMedicationService.list(max: 2, offset: 2)

        then:
        visitMedicationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        visitMedicationService.count() == 5
    }

    void "test delete"() {
        Long visitMedicationId = setupData()

        expect:
        visitMedicationService.count() == 5

        when:
        visitMedicationService.delete(visitMedicationId)
        sessionFactory.currentSession.flush()

        then:
        visitMedicationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VisitMedication visitMedication = new VisitMedication()
        visitMedicationService.save(visitMedication)

        then:
        visitMedication.id != null
    }
}
