package una.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MedicalProcedureController {

    MedicalProcedureService medicalProcedureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond medicalProcedureService.list(params), model:[medicalProcedureCount: medicalProcedureService.count()]
    }

    def show(Long id) {
        respond medicalProcedureService.get(id)
    }

    def create() {
        respond new MedicalProcedure(params)
    }

    def save(MedicalProcedure medicalProcedure) {
        if (medicalProcedure == null) {
            notFound()
            return
        }

        try {
            medicalProcedureService.save(medicalProcedure)
        } catch (ValidationException e) {
            respond medicalProcedure.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medicalProcedure.label', default: 'MedicalProcedure'), medicalProcedure.id])
                redirect medicalProcedure
            }
            '*' { respond medicalProcedure, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond medicalProcedureService.get(id)
    }

    def update(MedicalProcedure medicalProcedure) {
        if (medicalProcedure == null) {
            notFound()
            return
        }

        try {
            medicalProcedureService.save(medicalProcedure)
        } catch (ValidationException e) {
            respond medicalProcedure.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medicalProcedure.label', default: 'MedicalProcedure'), medicalProcedure.id])
                redirect medicalProcedure
            }
            '*'{ respond medicalProcedure, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        medicalProcedureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicalProcedure.label', default: 'MedicalProcedure'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalProcedure.label', default: 'MedicalProcedure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
