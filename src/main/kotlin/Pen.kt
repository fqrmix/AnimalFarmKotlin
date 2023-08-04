class Pen (private val type: String, private var animalList: AnimalList) : ItemContainer <Animal?> {

    override fun getType(): String {
        return this.type
    }

    override fun addItem(item: Animal?): AnimalList {
        if (item?.getType() == this.type) {
            this.animalList.add(item)
            println("Animal ${item?.getName()} successfully added to pen")
            return this.animalList
        } else throw Exception("Animal with type: ${item?.getType()} can't be placed in Pen with type: ${this.type}")
    }

    override fun removeItem(item: Animal?): AnimalList {
        this.animalList.remove(item)
        println("Animal ${item?.getName()} successfully removed from pen")
        return this.animalList
    }

    override fun getItems(): AnimalList {
        return this.animalList
    }

}