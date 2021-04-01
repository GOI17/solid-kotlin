fun List<Labor>.calculateTotal(): Float {
    return this.fold(0f) { acc, labor -> acc + labor.calculateTotal() }
}
