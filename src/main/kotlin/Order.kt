class Order(
    private val id: Int,
    private val customer: Customer,
    private val vehicle: Vehicle,
    private val tags: List<String>,
    private val notes: List<String>,
    private val repairServices: List<RepairService>,
    private val appointment: String,
) {
    fun getRepairServices() = repairServices

    fun getTotal(): Float = repairServices.fold(0f) { acc, repairService ->
        acc + repairService.calculateTotal()
    }

    fun orderInfo(): String {
        return """
           Order Id : $id
           Customer : ${customer.getName()}
           Vehicle : ${vehicle.getVehicleInfo()}
           Tags : ${tags.count()}
           Notes : ${notes.count()}
           Repair services : ${repairServices.count()}
           Appointment : $appointment
           Total : ${getTotal()}
        """.trimIndent()
    }

    override fun toString(): String {
        return "Order with id: $id"
    }
}