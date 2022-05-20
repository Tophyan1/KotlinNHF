package models


import java.awt.*


class Particle(override var pos: Point, override val charge: Double) : PointCharge, Drawable {

    val radius = 10.0

    fun calculateForce(p: PointCharge): Vector {
        val magnitude = calculateForceMagnitude(p)
        val force = pos.vectorTo(p.pos)
        force.normalize()
        force.scale(magnitude)
        return force
    }

    private fun calculateForceMagnitude(p: PointCharge): Double =
        9e9 * this.charge * p.charge / (this.pos.distanceTo(p.pos) * this.pos.distanceTo(p.pos))

    override fun draw(g: Graphics) {
        val originalColor = g.color
        val chargeColor = if (charge > 0) Color.red else Color.blue
        g.color = chargeColor
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