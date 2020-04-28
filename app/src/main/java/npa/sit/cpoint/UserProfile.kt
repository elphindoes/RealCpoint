package npa.sit.cpoint

class Userinformation {
    var userName: String? = null
    var userSurname: String? = null
    var userPhoneno: String? = null

    constructor() {}
    constructor(name: String?, surname: String?, phoneno: String?) {
        userName = name
        userSurname = surname
        userPhoneno = phoneno
    }

}