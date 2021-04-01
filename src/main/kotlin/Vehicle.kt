data class Vehicle(private val id: Int, private val year: Int, private val model: String, private val make: String) {
    fun getVehicleInfo() = "$make $model $year"
}