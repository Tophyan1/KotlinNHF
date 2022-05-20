package models

import java.awt.Color
import java.awt.Graphics

class Wall(x: Double, y: Double, height: Double, width: Double, level: Level?) : Rectangle(x, y, height, width, level),
    Drawable {

    constructor(x: Double, y: Double, height: Double, width: Double) : this(x, y, height, width, null)

    override fun onCollide() {
        level?.reset()
    }

    override fun draw(g: Graphics) {
        val originalColor = g.color
        g.color = Color.gray
        g.fillRect(x.toInt(), y.toInt(), width.toInt(), height.toInt())
        g.color = originalColor
    }
}