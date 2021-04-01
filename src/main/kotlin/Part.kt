data class Part(
    override val id: Int,
    override val description: String,
    val price: Float,
    override val quantity: Int,
    override val repairServiceId: Int
) :
    Element<Int> {
    override fun calculateTotal(): Float = price * quantity
}