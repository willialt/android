package com.lucas.practicekotlin

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true) :
    Phone(isScreenLightOn = true) {
    override fun switchOn(){
        super.switchOn()
        if (isFolded) {
            isScreenLightOn = false
        } else {
            isScreenLightOn = true
        }

    }
    fun openFold() {
        isFolded = false

    }
    fun closeFold() {
        isFolded = true
    }
    }

fun main() {
    var zfold7 = FoldablePhone()
//    zfold7.switchOn()
    zfold7.openFold()
    zfold7.switchOn()
    zfold7.checkPhoneScreenLight()
}
