interface Element<T> {
    val id: Int
    val description: String
    val quantity: T
    val repairServiceId: Int
    fun calculateTotal(): Float
}