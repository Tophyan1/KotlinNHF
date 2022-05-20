package view

import models.Game
import models.Particle
import models.Point
import java.awt.CardLayout
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame


class ChargeFrame: JFrame() {

    private val cardLayout: CardLayout
    private var gamePanel: GamePanel
    private val hallOfFamePanel: HallOfFamePanel

    init {
        title = "Charge!"
        cardLayout = CardLayout()
        layout = cardLayout
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(1280, 720)
        val menuPanel = MenuPanel()
        add(menuPanel)
        gamePanel = GamePanel()
        add(gamePanel)
        gamePanel.levelPanel.owner = this
        hallOfFamePanel = HallOfFamePanel()
        add(hallOfFamePanel)
        addListeners(menuPanel)
    }

    fun getIntoHallOfFame(score: Int) {
        WinDialog(this).run {
            isVisible = true
            OKButton.addActionListener {
                val playerName: String = this.nameField.text
                val currentPlayer = Player(playerName, score)
                val hallOfFame: MutableList<Player> = Player.readHallOfFame()
                hallOfFame.add(currentPlayer)
                Player.writeHallOfFame(hallOfFame)
                cardLayout.first(this@ChargeFrame.contentPane)
                this.dispose()
            }
        }
    }


    private fun addListeners(menuPanel: MenuPanel) {

        menuPanel.exitButton.addActionListener {
            processWindowEvent(
                WindowEvent(this@ChargeFrame, WindowEvent.WINDOW_CLOSING)
            )
        }

        menuPanel.startButton.addActionListener {
            gamePanel.levelPanel.game = Game()
            cardLayout.next(this@ChargeFrame.contentPane)
        }

        menuPanel.loadButton.addActionListener {
            cardLayout.next(this@ChargeFrame.contentPane)
            gamePanel.levelPanel.game.load("src/main/resources/SaveGame.dat")
        }

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent) {
                try {
                    gamePanel.levelPanel.game.save("src/main/resources/SaveGame.dat")
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        })

        gamePanel.quitButton.addActionListener {
            gamePanel.levelPanel.timer.stop()
            cardLayout.previous(this@ChargeFrame.contentPane)
        }

        gamePanel.saveButton.addActionListener {
            gamePanel.levelPanel.game.save(
                "src/main/resources/SaveGame.dat"
            )
        }

        gamePanel.removeButton.addActionListener {
            gamePanel.levelPanel.game.currentLevel().popParticle()
            gamePanel.repaint()
        }

        addMouseListenerToLevelPanel()

        gamePanel.startButton.addActionListener {
            gamePanel.levelPanel.game.currentLevel().timer = gamePanel.levelPanel.timer
            gamePanel.levelPanel.timer.start()
        }

        menuPanel.hallOfFameButton.addActionListener {
            hallOfFamePanel.showHallOfFame()
            cardLayout.last(this@ChargeFrame.contentPane)
        }

        hallOfFamePanel.backButton.addActionListener {
            cardLayout.first(this@ChargeFrame.contentPane)
        }

    }

    private fun addMouseListenerToLevelPanel() {
        gamePanel.levelPanel.addMouseListener(object : MouseListener {
            override fun mouseClicked(mouseEvent: MouseEvent) {
                val p = Point(mouseEvent.x.toDouble(), mouseEvent.y.toDouble())
                when (mouseEvent.button) {
                    MouseEvent.BUTTON1 -> {
                        gamePanel.levelPanel.game.currentLevel().pushParticle(Particle(p, 1e-5))
                    }
                    MouseEvent.BUTTON3 -> {
                        gamePanel.levelPanel.game.currentLevel().pushParticle(Particle(p, -1e-5))
                    }
                }
                gamePanel.repaint()
            }
            override fun mousePressed(mouseEvent: MouseEvent?) {}
            override fun mouseReleased(mouseEvent: MouseEvent?) {}
            override fun mouseEntered(mouseEvent: MouseEvent?) {}
            override fun mouseExited(mouseEvent: MouseEvent?) {}
        })
    }
}