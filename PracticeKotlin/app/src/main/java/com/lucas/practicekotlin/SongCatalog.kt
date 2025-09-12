package com.lucas.practicekotlin

class Song(val title: String, val artist: String, val yearPublished: Int, var playCount: Int){

    var popular:Boolean = if (playCount > 1000) {
        true
    } else {
        false
    }
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished")
    }
}

fun main() {
    val hitSong1 = Song("With Arms Wide Open", "Creed", 1999, 13000000)
    hitSong1.printDescription()
}