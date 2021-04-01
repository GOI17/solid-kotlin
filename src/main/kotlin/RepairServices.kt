fun List<RepairService>.calculateTotal(): Float {
    return this.fold(0f) { acc, repairService ->
        acc + repairService.calculateTotal()
    }
}