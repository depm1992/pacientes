package una.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedicalProcedureServiceSpec extends Specification {

    MedicalProcedureService medicalProcedureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MedicalProcedure(...).save(flush: true, failOnError: true)
        //new MedicalProcedure(...).save(flush: true, failOnError: true)
        //MedicalProcedure medicalProcedure = new MedicalProcedure(...).save(flush: true, failOnError: true)
        //new MedicalProcedure(...).save(flush: true, failOnError: true)
        //new MedicalProcedure(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //medicalProcedure.id
    }

    void "test get"() {
        setupData()

        expect:
        medicalProcedureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MedicalProcedure> medicalProcedureList = medicalProcedureService.list(max: 2, offset: 2)

        then:
        medicalProcedureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        medicalProcedureService.count() == 5
    }

    void "test delete"() {
        Long medicalProcedureId = setupData()

        expect:
        medicalProcedureService.count() == 5

        when:
        medicalProcedureService.delete(medicalProcedureId)
        sessionFactory.currentSession.flush()

        then:
        medicalProcedureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MedicalProcedure medicalProcedure = new MedicalProcedure()
        medicalProcedureService.save(medicalProcedure)

        then:
        medicalProcedure.id != null
    }
}
