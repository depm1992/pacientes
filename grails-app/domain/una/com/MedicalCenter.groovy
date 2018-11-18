package una.com

class MedicalCenter {

    Adress adress
    String otherDetails

    static belongsTo = [adress: Adress]

    static constraints = {
    }
}
