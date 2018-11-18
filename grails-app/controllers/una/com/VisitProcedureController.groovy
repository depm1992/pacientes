package una.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VisitProcedureController {

    VisitProcedureService visitProcedureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond visitProcedureService.list(params), model:[visitProcedureCount: visitProcedureService.count()]
    }

    def show(Long id) {
        respond visitProcedureService.get(id)
    }

    def create() {
        respond new VisitProcedure(params)
    }

    def save(VisitProcedure visitProcedure) {
        if (visitProcedure == null) {
            notFound()
            return
        }

        try {
            visitProcedureService.save(visitProcedure)
        } catch (ValidationException e) {
            respond visitProcedure.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visitProcedure.label', default: 'VisitProcedure'), visitProcedure.id])
                redirect visitProcedure
            }
            '*' { respond visitProcedure, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond visitProcedureService.get(id)
    }

    def update(VisitProcedure visitProcedure) {
        if (visitProcedure == null) {
            notFound()
            return
        }

        try {
            visitProcedureService.save(visitProcedure)
        } catch (ValidationException e) {
            respond visitProcedure.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'visitProcedure.label', default: 'VisitProcedure'), visitProcedure.id])
                redirect visitProcedure
            }
            '*'{ respond visitProcedure, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        visitProcedureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'visitProcedure.label', default: 'VisitProcedure'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visitProcedure.label', default: 'VisitProcedure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
