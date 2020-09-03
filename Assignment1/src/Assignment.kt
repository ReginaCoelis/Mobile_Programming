class Assignment {
    private val choices:List<Planets> = ArrayList(
        arrayListOf(
            Planets(1,"venus",0.78),
            Planets(2, "Mars", 0.39),
            Planets(3, "Jupiter", 2.65),
            Planets(4, "Saturn", 1.17),
            Planets(5, "Uranus", 1.05),
            Planets(6, "Neptune", 1.23)))

    fun planetWeight(choice: Int):String = when(choice){
        1 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        2 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        3 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        4 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        5 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        6 -> "Your weight on ${choices[choice-1].planet} is ${choices[choice-1].gravity*choice} pounds"
        else -> "Invalid selection"
    }

    fun choiceDisplay(){
        for(choice: Planets in choices){
            println("${choice.choice} ${choice.planet}")
        }
    }
}
class Planets(val choice:Int, val planet :String, val gravity: Double)

