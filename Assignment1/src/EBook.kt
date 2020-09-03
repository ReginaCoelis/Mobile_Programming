class EBook(var filetype:String, title:String,  author:String, price:Double): Book(title, author, price){

    override fun read(){
        println("Read from Electronic Device")
    }
}