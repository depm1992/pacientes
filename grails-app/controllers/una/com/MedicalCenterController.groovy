package una.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MedicalCenterController {

    MedicalCenterService medicalCenterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond medicalCenterService.list(params), model:[medicalCenterCount: medicalCenterService.count()]
    }

    def show(Long id) {
        respond medicalCenterService.get(id)
    }

    def create() {
        respond new MedicalCenter(params)
    }

    def save(MedicalCenter medicalCenter) {
        if (medicalCenter == null) {
            notFound()
            return
        }

        try {
            medicalCenterService.save(medicalCenter)
        } catch (ValidationException e) {
            respond medicalCenter.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medicalCenter.label', default: 'MedicalCenter'), medicalCenter.id])
                redirect medicalCenter
            }
            '*' { respond medicalCenter, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond medicalCenterService.get(id)
    }

    def update(MedicalCenter medicalCenter) {
        if (medicalCenter == null) {
            notFound()
            return
        }

        try {
            medicalCenterService.save(medicalCenter)
        } catch (ValidationException e) {
            respond medicalCenter.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medicalCenter.label', default: 'MedicalCenter'), medicalCenter.id])
                redirect medicalCenter
            }
            '*'{ respond medicalCenter, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        medicalCenterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicalCenter.label', default: 'MedicalCenter'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalCenter.label', default: 'MedicalCenter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
