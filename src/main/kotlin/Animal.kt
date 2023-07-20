abstract class Animal (private val name: String, private val type: String) {
    abstract fun makeSound() : String

    fun getName(): String {
        return name
    }

    fun getType(): String {
        return type
    }
}

class Dog (name: String) : Animal (name, "Dog") {
    override fun makeSound() : String {
        return "Woof! Woof!"
    }
}

class Cat (name: String) : Animal (name, "Cat") {
    override fun makeSound() : String {
        return "Meow! Meow!"
    }
}

class Cow (name: String) : Animal (name, "Cow") {
    override fun makeSound() : String {
        return "Moo! Moo!"
    }
}