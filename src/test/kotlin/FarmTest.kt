import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

class FarmTest {
    private lateinit var farm: Farm

    @BeforeEach
    fun setUp() {
        farm = Farm
    }

    @Test
    fun testFarmNotInitialized() {
        assertThrows<UninitializedPropertyAccessException> {
            farm.getType()
        }
        assertThrows<UninitializedPropertyAccessException> {
            farm.getItems()
        }
    }

    @Test
    fun testInitFarm() {
        val pen1 = Pen(
            "Cat",
            AnimalList(
                Cat("testAnimal1",),
                Cat("testAnimal2")
            )
        )
        val pen2 = Pen(
            "Dog",
            AnimalList(
                Dog("testAnimal3",),
                Dog("testAnimal4")
            )
        )
        farm.initFarm(pen1, pen2)

        assertEquals("Farm", farm.getType())
        assertEquals(mutableListOf(pen1, pen2), farm.getItems())
    }

    @Test
    fun invalidFarmInit() {
        val pen1 = Pen(
            "Cat",
            AnimalList(
                Cat("testAnimal1",),
                Cat("testAnimal2")
            )
        )
        assertThrows<Exception> {
            farm.initFarm(pen1)
        }
    }

    @Test
    fun testAddAndRemoveItems() {
        val pen1 = Pen(
            "Cat",
            AnimalList(
                Cat("testAnimal1",),
                Cat("testAnimal2")
            )
        )
        val pen2 = Pen(
            "Dog",
            AnimalList(
                Dog("testAnimal3",),
                Dog("testAnimal4")
            )
        )
        farm.initFarm(pen1, pen2)
        val itemsBeforeAdd: MutableList<Pen?> = farm.getItems().toMutableList()

        val pen3 = Pen(
            "Cow",
            AnimalList(
                Cow("testAnimal5",),
                Cow("testAnimal6")
            )
        )

        farm.addItem(pen3)
        val itemsAfterAdd: MutableList<Pen?> = farm.getItems().toMutableList()


        assertTrue(itemsBeforeAdd.size + 1 == itemsAfterAdd.size)
        assertTrue(itemsAfterAdd.contains(pen3))

        val itemsBeforeRemove = farm.getItems().toMutableList()

        farm.removeItem(pen1)

        val itemsAfterRemove = farm.getItems().toMutableList()

        assertTrue(itemsBeforeRemove.size - 1 == itemsAfterRemove.size)
        assertFalse(itemsAfterRemove.contains(pen1))

    }
}