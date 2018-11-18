package una.com

class VisitProcedure {

    int quantity
    Double derivedCostOfProcedures

    static belongsTo = [medicalProcedure: MedicalProcedure, visit: Visit]

    static constraints = {
    }
}
