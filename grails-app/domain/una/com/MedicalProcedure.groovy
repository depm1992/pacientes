package una.com

class MedicalProcedure {

    String medicalProcedureName
    Double procedureCost
    String otherDetails

    static hasMany = [visitProcedures: VisitProcedure]

    static constraints = {
    }
}
