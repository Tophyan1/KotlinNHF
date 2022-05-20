package models

import kotlin.math.sqrt

class Vector(var x: Double, var y: Double): java.io.Serializable {

    fun scale(d: Double): Vector {
        x *= d
        y *= d
        return this
    }

    fun length() = sqrt(x*x + y*y)

    fun normalize(): Vector {
        val len = length()
        x /= len
        y /= len
        return this
    }

    fun add(other: Vector): Vector {
        x += other.x
        y += other.y
        return this
    }

    fun clone() = Vector(x, y)

}