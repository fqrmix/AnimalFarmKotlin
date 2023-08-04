interface ItemContainer<T> {
    fun getType(): String?
    fun addItem(item: T?): List<T?>
    fun removeItem(item: T?): List<T?>
    fun getItems(): List<T?>
}