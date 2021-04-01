data class RepairService(
    private val id: Int,
    private val name: String,
    private val parts: List<Part>,
    private val labors: List<Labor>
) {
    fun getRepairServiceInfo() = "$name has ${parts.count()} parts and ${labors.count()} labors"
    fun calculateTotal(): Float = parts.calculateTotal() + labors.calculateTotal()
}