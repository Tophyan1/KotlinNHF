package view

import java.awt.Color
import java.awt.Font
import javax.swing.*


class HallOfFamePanel: JPanel() {

    lateinit var title: JLabel
    lateinit var champList: JList<String>
    lateinit var backButton: JButton

    init {
        background = Color.black
        layout = null
        initTitle()
        initButton()
    }

    private fun initButton() {
        backButton = JButton("Back").apply {
            setBounds(600, 590, 80, 30)
            this@HallOfFamePanel.add(this@apply)
        }
    }

    private fun initTitle() {
        title = JLabel("Hall of Fame").apply {
            background = Color.black
            foreground = Color.white
            font = Font("Ubuntu", Font.BOLD, 48)
            setBounds(390, 50, 500, 130)
            horizontalAlignment = SwingConstants.CENTER
            this@HallOfFamePanel.add(this@apply)
        }
    }

    fun showHallOfFame() {
        val listModel = DefaultListModel<String>()
        val list: List<Player> = Player.readHallOfFame()
        for (player in list) {
            listModel.addElement(player.toString())
        }
        champList = JList(listModel).apply {
            setBounds(390, 190, 500, 400)
            font = Font("Ubuntu", Font.BOLD, 28)
            background = Color.black
            foreground = Color.white
        }
        (champList.cellRenderer as DefaultListCellRenderer).apply {
            horizontalAlignment = SwingConstants.CENTER
            isFocusable = false
        }
        this.add(champList)
    }
}