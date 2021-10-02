import kotlin.math.sqrt
import kotlin.random.Random

fun isPrime(number:Int) :Boolean{
    if(0 == number || 1 == number) return false
    val root = sqrt(number.toDouble())
    for(i in 2..root.toInt()){
        if(number%i == 0){
            return false
        }
    }
    return true
}

fun encode(word:String):String{
    var newWord = "";
    for(c in word){
        when (c) {
            'z' -> {
               newWord = newWord.plus('a')
            }
            'Z' -> {
                newWord = newWord.plus('A')
            }
            in 'A'..'z' -> {
                newWord = newWord.plus(c+1)
            }
            else -> {
                newWord = newWord.plus(c)
            }
        }
    }
    return newWord
}

fun decode(word:String):String{
    var newWord = "";
    for(c in word){
        when (c) {
            'a' -> {
                newWord = newWord.plus('z')
            }
            'A' -> {
                newWord = newWord.plus('Z')
            }
            in 'A'..'z' -> {
                newWord = newWord.plus(c-1)
            }
            else -> {
                newWord = newWord.plus(c)
            }
        }
    }
    return newWord
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

fun even(x: Int):Boolean = x%2 == 0

fun main(args: Array<String>) {
    //Exercise 1.
    val number1 = 5
    val number2 = 7
    println("$number1 + $number2 = ${number1+number2}")

    //Exercise 2.
    val daysOfWeek = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    print("The days of the week: ")
    for(day in daysOfWeek){
        print("$day ")
    }
    println();
    print("Days of week starting with T: ")
    val daysStartingWithT = daysOfWeek.filter{(it.startsWith("T"))}
    for(day in daysStartingWithT){
        print("$day ")
    }
    println()
    print("Days of week containing e: ")
    daysOfWeek.filter{(it.contains("e"))}
        .forEach{(print("$it "))}
    println();
    print("All days with length 6: ")
    daysOfWeek.filter{(it.length == 6)}
        .forEach{(print("$it "))}

    //Exercise 3.
    println()
    print("Prime numbers between 1 and 50: ")
    for(i in 1..50){
        if(isPrime(i)){
            print("$i ")
        }
    }

    //Exercise 4.
    println();
    val word = "panda"
    val newWord = encode(word)
    print("Test: $word -> $newWord -> ${decode(newWord)}")
    println()
    val word1 = "Hi! How are you?";
    val newWord1 = messageCoding(word1,::encode)
    print("The message: $word1 ->  $newWord1 -> ${messageCoding(newWord1,::decode)}")

    //Exercise 5.
    println()
    val listOfNumber = listOf(2,4,51,21,12,66,5)
    print("The even numbers: ")
    for(number in listOfNumber){
        if(even(number)){
            print("$number ")
        }
    }

    //Exercise 6.
    println()
    print("Double the numbers: ${listOfNumber.map{it*2}}")
    println()
    print("Days of week capitalized: ${daysOfWeek.map{it.uppercase()}} ")
    println()
    print("The first character of days : ${daysOfWeek.map{it.first().lowercase()}} ")
    println()
    print("Length of days: ${daysOfWeek.map{it.length}} ")
    println()
    print("Average: ${daysOfWeek.map{it.length}.average()}")

    //Exercise 7.
    println()
    val daysOfWeekMutable = daysOfWeek.toMutableList()
    daysOfWeekMutable.removeIf { it.contains('n')}
    print("Days without n letter: ")
    for(days in daysOfWeekMutable){
        print("$days ");
    }
    println()
    for((index,day) in daysOfWeekMutable.withIndex()){
        println("Item at $index is $day")
    }
    daysOfWeekMutable.sort();
    print("Sorted: ")
    for(days in daysOfWeekMutable){
        print("$days ");
    }

    //Exercise 8.
    val arrayOfNumber = IntArray(10){ Random.nextInt(0,100)}
    print("Numbers: ")
    arrayOfNumber.forEach { println(it) }
    print("Numbers sorted: ")
    arrayOfNumber.sort();
    arrayOfNumber.forEach { println(it) }
    val check1 = arrayOfNumber.any { even(it) }
    if(check1){
        println("The array contains even number.")
    }
    else{
        println("The array not contains even number.")
    }
    val check2 = arrayOfNumber.all{ even(it) }
    if(check2){
        println("All the numbers are even.")
    }
    else{
        println("The array contains odd number.")
    }
    var avg = 0.0;
   arrayOfNumber.forEach{ avg += it}
    println("The average: ${avg/arrayOfNumber.size}")

}