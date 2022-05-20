package view

import models.Game
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JPanel
import javax.swing.Timer

class LevelPanel: JPanel(), ActionListener {

    lateinit var owner: ChargeFrame
    var game: Game
    val timer: Timer

    init {
        background = Color.black
        game = Game()
        timer = Timer(20, this)
    }

    override fun paint(g: Graphics) {
        super.paint(g)
        game.currentLevel().draw(g)
    }

    override fun actionPerformed(e: ActionEvent?) {
        game.step(0.02)
        repaint()
        if (game.isGameOver) {
            owner.getIntoHallOfFame(game.getScore())
        }
    }
}