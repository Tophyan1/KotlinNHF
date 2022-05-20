package view


import java.awt.Color
import javax.swing.JButton
import javax.swing.JPanel


class MenuPanel: JPanel() {
    lateinit var startButton: JButton
    lateinit var loadButton: JButton
    lateinit var hallOfFameButton: JButton
    lateinit var exitButton: JButton


    init {
        setSize(1280, 720)
        background = Color.black
        layout = null
        setUpAllButtons()
    }

    private fun setUpAllButtons() {
        setUpNewGameButton()
        setUpLoadGameButton()
        setUpHallOfFameButton()
        setUpExitButton()
    }

    private fun setUpExitButton() {
        exitButton = JButton("Exit").apply {
            setBounds(540, 425, 200, 50)
            this@MenuPanel.add(this@apply)
        }
    }

    private fun setUpHallOfFameButton() {
        hallOfFameButton = JButton("Hall of Fame").apply {
            setBounds(540, 350, 200, 50)
            this@MenuPanel.add(this@apply)
        }
    }

    private fun setUpLoadGameButton() {
        loadButton = JButton("Load Game").apply {
            setBounds(540, 275, 200, 50)
            this@MenuPanel.add(this@apply)
        }
    }

    private fun setUpNewGameButton() {
        startButton = JButton("New Game").apply {
            setBounds(540, 200, 200, 50)
            this@MenuPanel.add(this@apply)
        }
    }

}