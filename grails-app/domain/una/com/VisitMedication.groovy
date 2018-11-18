package una.com

class VisitMedication {

    int quantity
    Double derivedCostOfMedication

    static belongsTo = [medication: Medication, visit: Visit]

    static constraints = {
    }
}
