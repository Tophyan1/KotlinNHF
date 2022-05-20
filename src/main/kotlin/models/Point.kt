package models

import kotlin.math.sqrt

class Point(var x: Double, var y: Double): java.io.Serializable {

    fun distanceTo(other: Point): Double {
        val dx = this.x - other.x
        val dy = this.y - other.y
        return sqrt(dx*dx + dy*dy)
    }

    fun vectorTo(point: Point) = Vector(point.x - this.x, point.y - this.y)

    fun moveBy(v: Vector): Point {
        this.x += v.x
        this.y += v.y
        return this
    }

}