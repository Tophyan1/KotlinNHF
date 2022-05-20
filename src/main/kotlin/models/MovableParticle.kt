package models

import java.awt.Color
import java.awt.Graphics

class MovableParticle(override var pos: Point, override val charge: Double) : PointCharge, Drawable,
    java.io.Serializable {

    var velocity = Vector(100.0, 0.0)
    val mass = 1.0
    val radius = 10.0

    fun move(force: Vector, deltaTime: Double) {
        val acceleration = force.clone().scale(1.0 / mass)
        velocity.add(acceleration.scale(deltaTime))
        pos.moveBy(velocity.clone().scale(deltaTime))

    }

    override fun draw(g: Graphics) {
        val originalColor = g.color
        g.color = Color.yellow
        g.fillOval(
            (pos.x - radius).toInt(),
            (pos.y - radius).toInt(),
            (radius * 2).toInt(),
            (radius * 2).toInt()
        )
        g.color = Color.black
        g.drawOval(
            (pos.x - radius).toInt(),
            (pos.y - radius).toInt(),
            (radius * 2).toInt(),
            (radius * 2).toInt()
        )
        g.color = originalColor
    }
}