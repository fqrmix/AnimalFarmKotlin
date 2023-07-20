interface PenInterface {
    fun getType() : String
    fun addAnimal(animal: Animal) : MutableList<String>
    fun removeAnimal(animal: Animal) : MutableList<String>
    fun getAnimalsInside() : MutableList<Animal>
}

class Pen (private val type: String, private var animalList: AnimalList) : PenInterface {

    override fun getType(): String {
        return this.type
    }

    override fun addAnimal(animal: Animal) : MutableList<String> {
        if (animal.getType() == this.type) {
            this.animalList.add(animal)
            println("Animal ${animal.getName()} successfully added to pen")
            return this.getAnimalsInsideToString()
        } else throw Exception("Animal with type: ${animal.getType()} can't be placed in Pen with type: ${this.type}")

    }

    override fun removeAnimal(animal: Animal) : MutableList<String> {
        this.animalList.remove(animal)
        println("Animal ${animal.getName()} successfully removed from pen")
        return this.getAnimalsInsideToString()
    }

    override fun getAnimalsInside() : MutableList<Animal> {
        return this.animalList
    }

    private fun getAnimalsInsideToString() : MutableList<String> {
        val result: MutableList<String> = mutableListOf()
        this.animalList.forEach {
            result.add(it.getName())
        }
        return result
    }
}