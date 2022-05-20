package models

import java.awt.Color
import java.awt.Graphics

class Goal(x: Double, y: Double, height: Double, width: Double, level: Level?) : Rectangle(x, y, height, width, level), Drawable{

    constructor(x: Double, y: Double, height: Double, width: Double) : this(x, y, height, width, null)

    override fun onCollide() {
        level?.finishLevel()
    }

    override fun draw(g: Graphics) {
        val originalColor = g.color
        g.color = Color.red
        g.fillRect(x.toInt(), y.toInt(), width.toInt(), height.toInt())
        g.color = originalColor
    }


}