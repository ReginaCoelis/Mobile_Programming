open class Book {

    var title:String
     get() = title
    var author:String
    var price:Double

    constructor(title:String, author:String, price:Double){
        this.title= title
        this.author= author
        this.price = price
    }

    open fun read(){
        println("“Reading Paper book")
    }
}