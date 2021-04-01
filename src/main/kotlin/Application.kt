fun main() {
    val parts = listOf(Part(1, "oil", 120.50f, 1, 1))
    val labors = listOf(Labor(1, "installation", 1.2f, 1))
    val repairServices = listOf(RepairService(1, "Change motor oil", parts, labors))
    val order = Order(
        id = 1,
        customerFirstName = "John",
        customerLastName = "Doe",
        vehicleYear = 2012,
        vehicleMake = "Honda",
        vehicleModel = "Accord",
        tags = listOf("new", "important", "first time"),
        notes = listOf("check front wheels"),
        repairServices = repairServices,
        appointment = "2021/04/12"
    )
    order.print()
}