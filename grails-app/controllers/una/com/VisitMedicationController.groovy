package una.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VisitMedicationController {

    VisitMedicationService visitMedicationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond visitMedicationService.list(params), model:[visitMedicationCount: visitMedicationService.count()]
    }

    def show(Long id) {
        respond visitMedicationService.get(id)
    }

    def create() {
        respond new VisitMedication(params)
    }

    def save(VisitMedication visitMedication) {
        if (visitMedication == null) {
            notFound()
            return
        }

        try {
            visitMedicationService.save(visitMedication)
        } catch (ValidationException e) {
            respond visitMedication.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visitMedication.label', default: 'VisitMedication'), visitMedication.id])
                redirect visitMedication
            }
            '*' { respond visitMedication, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond visitMedicationService.get(id)
    }

    def update(VisitMedication visitMedication) {
        if (visitMedication == null) {
            notFound()
            return
        }

        try {
            visitMedicationService.save(visitMedication)
        } catch (ValidationException e) {
            respond visitMedication.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'visitMedication.label', default: 'VisitMedication'), visitMedication.id])
                redirect visitMedication
            }
            '*'{ respond visitMedication, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        visitMedicationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'visitMedication.label', default: 'VisitMedication'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visitMedication.label', default: 'VisitMedication'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
