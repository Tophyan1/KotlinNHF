package models

abstract class Rectangle(
    val x: Double,
    val y: Double,
    val height: Double,
    val width: Double,
    override var level: Level?
) :
    Collidable, Drawable, java.io.Serializable {


    override fun didCollide(p: MovableParticle): Boolean {
        val nearestX = maxOf(this.x, minOf(p.pos.x, this.x + this.width))
        val nearestY = maxOf(this.y, minOf(p.pos.y, this.y + this.height))
        val dx = p.pos.x - nearestX
        val dy = p.pos.y - nearestY
        return (p.radius * p.radius) >= dx * dx + dy * dy
    }

}