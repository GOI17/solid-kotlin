fun main() {
    val parts = listOf(Part(1, "oil", 120.50f, 1, 1))
    val parts2 = listOf(
        Part(1, "oil", 120.50f, 1, 1),
        Part(1, "front right wheel", 320.50f, 1, 1),
    )
    val labors = listOf(Labor(1, "installation", 1.2f, 1))
    val repairServices = listOf(
        RepairService(1, "Change motor oil", parts, labors),
        RepairService(2, "Change motor oil 2", parts2, labors),
    )
    val order = Order(
        id = 1,
        customer = Customer(1, "John", lastName = "Doe"),
        vehicle = Vehicle(1, 2020, "Nissan", "Sentra"),
        tags = listOf("new", "important", "first time"),
        notes = listOf("check front wheels"),
        repairServices = repairServices,
        appointment = "2021/04/12"
    )
    print(order.orderInfo())
    order.getRepairServices().forEach {
        println(it.getRepairServiceInfo())
        println("Total: ${it.calculateTotal()}")
    }
}