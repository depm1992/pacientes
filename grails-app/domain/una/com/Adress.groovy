package una.com

class Adress {

    String line1NumberBuilding
    String line2NumberStreet
    String line3AreaLocality
    String city
    String zipCode
    String stateProvinceCountry
    String country

    static hasMany = [patients: Patient, medicalCenters: MedicalCenter, doctors: Doctor]

    static constraints = {
    }
}
