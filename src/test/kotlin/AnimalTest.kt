import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnimalTest {

    @Test
    fun testDogGetName () {
        val dog = Dog("TestDog")
        val name = dog.getName()
        assertEquals("TestDog", name)
    }

    @Test
    fun testDogGetType () {
        val dog = Dog("TestDog")
        val type = dog.getType()
        assertEquals("Dog", type)
    }

    @Test
    fun testDogMakeSound() {
        val dog = Dog("TestDog")
        val dogSound = dog.makeSound()
        assertEquals("Woof! Woof!", dogSound)
    }

    @Test
    fun testCatGetName () {
        val cat = Cat("TestCat")
        val name = cat.getName()
        assertEquals("TestCat", name)
    }

    @Test
    fun testCatGetType () {
        val cat = Cat("TestCat")
        val type = cat.getType()
        assertEquals("Cat", type)
    }

    @Test
    fun testCatMakeSound() {
        val cat = Cat("TestCat")
        val catSound = cat.makeSound()
        assertEquals("Meow! Meow!", catSound)
    }

}