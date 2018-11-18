package una.com

class Visit {

    Date visitDateAndTime
    Double totalCostOfVisit
    String otherDetails

    static hasMany = [visitProcedures: VisitProcedure, visitMedications: VisitMedication]
    static belongsTo = [doctor: Doctor, patient: Patient]

    static constraints = {
    }
}
