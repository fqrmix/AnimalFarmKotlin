// Пример класса Animal с инкапсуляцией и наследованием

fun main() {
    val animalNumberOne: Animal = Dog("Petya")
    val animalNumberTwo: Animal = Cat("Persik")

    println( "It's a " + animalNumberOne.getType()
            + " with name " + animalNumberOne.getName()
            + ", and it sounds like this: " + animalNumberOne.makeSound()
    )

    println( "It's a " + animalNumberTwo.getType()
            + " with name " + animalNumberTwo.getName()
            + ", and it sounds like this: " + animalNumberTwo.makeSound()
    )

    val animalNumberThree: Animal = Cat("Barsik")
    val catPen = Pen("Cat", AnimalList(animalNumberTwo, animalNumberThree))

    println(catPen.getType())
    println(catPen.getAnimalsInside())

    val dogPen = Pen("Dog", AnimalList(animalNumberOne, Dog("Vasya")))

    val myFarm = Farm

    myFarm.init(mutableListOf(catPen, dogPen))
    println(myFarm.getPenList()[1].getAnimalsInside()[1].getName())

}