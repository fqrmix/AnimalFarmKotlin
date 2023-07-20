class AnimalList(vararg animals: Animal) : AbstractMutableList<Animal>() {

    private val internalList = mutableListOf(*animals)

    override val size: Int
        get() = internalList.size

    override fun add(index: Int, element: Animal) {
        internalList.add(index, element)
    }

    override fun removeAt(index: Int): Animal {
        return internalList.removeAt(index)
    }

    override fun set(index: Int, element: Animal): Animal {
        return internalList.set(index, element)
    }

    override fun get(index: Int): Animal {
        return internalList[index]
    }
}
