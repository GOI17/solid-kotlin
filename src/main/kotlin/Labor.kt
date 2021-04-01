data class Labor(
    override val id: Int,
    override val description: String,
    override val quantity: Float,
    override val repairServiceId: Int
) :
    Element<Float> {
    override fun calculateTotal(): Float = quantity * 34.36f
}