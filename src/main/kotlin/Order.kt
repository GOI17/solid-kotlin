interface Element<T> {
    val id: Int
    val description: String
    val quantity: T
    val repairServiceId: Int
}

data class Part(
    override val id: Int, override val description: String, val price: Float, override val quantity: Int,
    override val repairServiceId: Int
) :
    Element<Int>

data class Labor(
    override val id: Int,
    override val description: String,
    override val quantity: Float,
    override val repairServiceId: Int
) :
    Element<Float>

data class RepairService(val id: Int, val name: String, val parts: List<Part>, val labors: List<Labor>)

class Order(
    private val id: Int,
    private val customerFirstName: String,
    private val customerLastName: String,
    private val vehicleYear: Int,
    private val vehicleModel: String,
    private val vehicleMake: String,
    private val tags: List<String>,
    private val notes: List<String>,
    private val repairServices: List<RepairService>,
    private val appointment: String,
) {
    private fun getId() = id
    private fun getCustomerName() = "$customerFirstName $customerLastName"
    private fun getVehicle() = "$vehicleMake $vehicleModel $vehicleYear"
    private fun getTags() = tags
    private fun getNotes() = notes
    private fun getRepairServices() = repairServices
    private fun getAppointment() = appointment
    private fun getTotal(): Float = repairServices.fold(0f) { repairServiceTotal, repairService ->
        val laborsTotal = repairService.labors
            .filter { it.repairServiceId == repairService.id }
            .fold(0f) { laborTotal, labor -> laborTotal + (labor.quantity * 34.36f) }
        val partsTotal = repairService.parts
            .filter { it.repairServiceId == repairService.id }
            .fold(0f) { partTotal, part -> partTotal + (part.quantity * part.price) }
        return repairServiceTotal + laborsTotal + partsTotal
    }

    fun print() {
        println(
            """
           Order Id : ${getId()}
           Customer : ${getCustomerName()}
           Vehicle : ${getVehicle()}
        """.trimIndent()
        )
        println("Tags: ")
        getTags().forEach {
            println(it)
        }
        println("Notes: ")
        getNotes().forEach {
            println(it)
        }
        println("Repair services: ")
        getRepairServices().forEach {
            println("   ${it.name}")
            println("   Labors: ")
            it.labors.filter { labor -> labor.repairServiceId == it.id }.forEach { labor ->
                println("       ${labor.description}")
            }
            println("   Parts: ")
            it.parts.filter { part -> part.repairServiceId == it.id }.forEach { part ->
                println("       ${part.description}")
            }
        }
        println(
            """
            Appointment : ${getAppointment()}
            Total : ${getTotal()}
        """.trimIndent()
        )
    }

    override fun toString(): String {
        return "Order with id: ${getId()}"
    }
}