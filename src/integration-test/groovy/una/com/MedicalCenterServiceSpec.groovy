package una.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedicalCenterServiceSpec extends Specification {

    MedicalCenterService medicalCenterService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MedicalCenter(...).save(flush: true, failOnError: true)
        //new MedicalCenter(...).save(flush: true, failOnError: true)
        //MedicalCenter medicalCenter = new MedicalCenter(...).save(flush: true, failOnError: true)
        //new MedicalCenter(...).save(flush: true, failOnError: true)
        //new MedicalCenter(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //medicalCenter.id
    }

    void "test get"() {
        setupData()

        expect:
        medicalCenterService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MedicalCenter> medicalCenterList = medicalCenterService.list(max: 2, offset: 2)

        then:
        medicalCenterList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        medicalCenterService.count() == 5
    }

    void "test delete"() {
        Long medicalCenterId = setupData()

        expect:
        medicalCenterService.count() == 5

        when:
        medicalCenterService.delete(medicalCenterId)
        sessionFactory.currentSession.flush()

        then:
        medicalCenterService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MedicalCenter medicalCenter = new MedicalCenter()
        medicalCenterService.save(medicalCenter)

        then:
        medicalCenter.id != null
    }
}
