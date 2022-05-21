package dev.olaore.ifytestapp

data class User(
    val username: String? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val address: String? = null,
    val geopolicaticalZone: String? = null
)

fun isUserProvidedValid(user: User): Boolean {
    val allNames = listOf(
        user.username, user.firstname, user.lastname, user.address, user.geopolicaticalZone
    )
    return allNames.map { it != null }.contains(true)
}

fun String.orNull() = ifEmpty { null }
