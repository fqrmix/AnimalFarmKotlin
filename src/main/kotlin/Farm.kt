interface FarmInterface {
    fun init(penList : MutableList<Pen>)
    fun getPenList() : MutableList<Pen>
    fun addPen(pen: Pen) : MutableList<Pen>
    fun removePen(pen: Pen) : MutableList<Pen>
}

object Farm : FarmInterface {

    private var penList : MutableList<Pen> = mutableListOf()
    private var initState = false

    init {
        println("Farm object was created, but you must initialize farm to interact with it")
    }

    private fun checkIsInitialized() : Boolean {
        if (!this.initState) {
            throw Exception("You must initialize farm to interact with it. Use Farm.init() to do that")
        } else return true
    }

    override fun init(penList : MutableList<Pen>) {

        if (penList.size <= 1) {
            throw Exception("Pen list length must be at least 2 for farm initializing")
        }

        if (this.initState) {
            throw Exception("Farm was already initialized")
        }

        this.penList = penList
        this.initState = true
    }

    override fun getPenList(): MutableList<Pen> {
        this.checkIsInitialized()
        return this.penList
    }

    override fun addPen(pen: Pen): MutableList<Pen> {
        this.checkIsInitialized()
        this.penList.add(pen)
        return this.getPenList()
    }

    override fun removePen(pen: Pen): MutableList<Pen> {
        this.checkIsInitialized()
        return this.getPenList()
    }
}