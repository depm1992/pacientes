package una.com

class Patient {

    Adress adress
    String firstName
    String middleName
    String lastName
    String gender
    Date dateOfBirth
    Date dateOfbecamePacient
    String othersDetails

    static hasMany = [visits: Visit]

    static constraints = {
    }
}
