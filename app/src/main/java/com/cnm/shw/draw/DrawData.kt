package com.cnm.shw.draw

data class DrawData(val body: Body) {
    data class Body(
        val startX: Float,
        val startY: Float,
        val endX: Float,
        val endY: Float,
        val select: Int,
        val color: Int
    )
}