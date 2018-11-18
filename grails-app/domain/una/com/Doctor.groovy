package una.com

class Doctor {

    String doctorsName
    String contactDetail
    String otherDetail

    static hasMany = [visits: Visit]
    static belongsTo = [adress: Adress, medicalCenter: MedicalCenter]

    static constraints = {
    }
}
