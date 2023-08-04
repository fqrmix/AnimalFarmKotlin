object Farm : ItemContainer <Pen?> {

    private var penList : MutableList<Pen?> = mutableListOf()
    private var initState = false
    private var type: String? = null

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION)
    private annotation class InitCheck

    init {
        println("Farm object was created, but you must initialize farm to interact with it")
    }

    fun initFarm(vararg pen: Pen?) {

        if (mutableListOf(*pen).size <= 1) {
            throw Exception("Pen list length must be at least 2 for farm initializing")
        }

        penList = mutableListOf(*pen)
        initState = true
        type = "Farm"
    }


    override fun getType(): String? {
        initStateCheck { }
        return type
    }

    @InitCheck
    override fun getItems(): MutableList<Pen?> {
        initStateCheck { }
        return penList
    }

    @InitCheck
    override fun removeItem(item: Pen?): MutableList<Pen?> {
        initStateCheck {
            penList.remove(item!!)
        }
        return this.getItems()
    }

    @InitCheck
    override fun addItem(item: Pen?): MutableList<Pen?> {
        initStateCheck {
            penList.add(item!!)
        }
        return this.getItems()

    }

    private fun initStateCheck(action: () -> Unit) {
        if (initState) {
            action()
        } else {
            throw UninitializedPropertyAccessException("Farm is not initialized!")
        }
    }
}