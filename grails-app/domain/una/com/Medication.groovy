package una.com

class Medication {

    String medicationName
    Double medicationCost
    String otherDetails

    static hasMany = [visitMedications: VisitMedication]

    static constraints = {
    }
}
