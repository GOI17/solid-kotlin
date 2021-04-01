data class Customer(
    private val id: Int,
    private val firstName: String,
    private val middleName: String? = "",
    private val lastName: String
) {
    fun getName() = "$firstName $middleName $lastName"
}