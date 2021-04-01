fun List<Part>.calculateTotal(): Float {
    return this.fold(0f) { acc, part -> acc + part.calculateTotal() }
}