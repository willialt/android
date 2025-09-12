package com.lucas.practicekotlin
fun main() {
    // define a lambda function that can be sent as a parameter
    val coins: (Int) -> String = {
//         quantity -> "$quantity quarters"  // Int named quantity
        "$it quarters"
    }
//     val cupcake: (Int) -> String = {
//     	"have a cupcake"
//     }

//     val treatFunction = trickOrTreat(false, coins)
//     val treatFunction = trickOrTreat(false, { "$it quarters"}) // direct without predefined coins
    val treatFunction = trickOrTreat(false) { "$it quarters" } // trailing lambda syntax
    val trickFunction = trickOrTreat(true, null)
    treatFunction()

    println()
    trickFunction()
    repeat(4) {
        treatFunction()
    }
}


// returns a function and receives function as parameter
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    // () -> Unit means function returns a function with no parameters or return type
    // extraTreat: (Int) -> String) means this func takes that type of func as a parameter
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

// short hand tricks:
// when passing one parameter into a lambda you can reference it with it keyword