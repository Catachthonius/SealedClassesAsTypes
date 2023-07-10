fun main() {

    //Write sealed class for a type User that uses data classes for different types: Email, Facebook, Google.
    // They need to each have an id, and optionally password or email. Use them in a when inside a method
    // to return a printable value as String.

    val userEmail = User.Email("utente1", "utente1@email1.com", "passwordemail")
    val userFacebook = User.Facebook("utente2", "utente2facebook", "utente2@meta.com", "passwordfacebook")
    val userGoogle = User.Google("utente3", "utente3google", "utente3@gmail.com", "passwordgoogle")

    println(userEmail.details())
    println(userFacebook.details())
    println(userGoogle.details())
}

sealed class User {

    abstract val id: String

    data class Email(
        override val id: String,
        val email: String,
        val password: String
    ) : User()

    data class Google(
        override val id: String,
        val googleId: String,
        val googleEmail: String,
        val googlePassword: String
    ) : User()

    data class Facebook(
        override val id: String,
        val facebookId: String,
        val facebookEmail: String,
        val facebookPassword: String
    ) : User()


    fun details(): String {
        return when (this) {
            is Email -> "Email data: (User Id: $id, Email: $email, Password: $password)"
            is Facebook -> "Facebook data: (User Id: $id, Facebook Id: $facebookId, Facebook Email: $facebookEmail, Facebook Password: $facebookPassword)"
            is Google -> "Google data: (User Id: $id, Google Id: $googleId, Google Email: $googleEmail, Google Password: $googlePassword)"
        }
    }
}

