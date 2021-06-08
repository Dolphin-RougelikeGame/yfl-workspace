package com.example.dolphin.bussiness.parts

class Border {
    // According to the two coordinates
    var leftUpX: Double = 0.0
    var leftUpY: Double = 0.0
    var rightDownX: Double = 0.0
    var rightDownY: Double = 0.0
    fun Border(leftUpX: Double, leftUpY: Double, rightDownX: Double, rightDownY: Double){
        this.leftUpX = leftUpX
        this.leftUpY = leftUpY
        this.rightDownX = rightDownX
        this.rightDownY = rightDownY
    }
}