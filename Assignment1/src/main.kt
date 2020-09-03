import java.lang.NumberFormatException

fun main(args:Array<String>){
    val nums: String = "Numbers";
    println(nums)

    val one:Assignment = Assignment()



    //problem 3a
    fun firstLast(digit:Int):String{
        val digitToString = digit.toString()
        var firstDigit = digitToString[0]
        // println (firstDigit);
        var lastDigit = digitToString[digitToString.length-1]
        return " first Digit: $firstDigit   last Digit: $lastDigit"
    }
    println(firstLast(305))

    //problem 3b
    fun squaredNums(nums :IntArray):Int{
        var sum = 0
        for (num in nums){
            if( num%2 != 0){
                sum += num*num
            }
        }
        return sum
    }
    println(squaredNums(intArrayOf(2,4,5,1)))

    //problem 3c
    println("Select planet")
    one.choiceDisplay()
    println("Your choices is: ")
    try {
        var choice: Int = readLine()!!.toInt()
        println(one.planetWeight(choice))
    }catch(e:NumberFormatException){
        println("Invalid selection.")
    }


}
