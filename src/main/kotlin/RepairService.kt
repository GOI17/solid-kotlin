data class RepairService(
    private val id: Int,
    private val name: String,
    private val parts: List<Element<Int>>,
    private val labors: List<Element<Float>>
) {
    fun getRepairServiceInfo() = "$name has ${parts.count()} parts and ${labors.count()} labors"
    fun calculateTotal(): Float {
        val partsTotal = parts.fold(0f) { acc, part -> acc + part.calculateTotal() }
        val laborsTotal = labors.fold(0f) { acc, labor -> acc + labor.calculateTotal() }
        return partsTotal + laborsTotal
    }
}