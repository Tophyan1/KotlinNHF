package view

import java.awt.Color
import java.awt.Dimension
import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.LayoutStyle


class GamePanel : JPanel() {

    lateinit var controlPanel: JPanel
    lateinit var removeButton: JButton
    lateinit var startButton: JButton
    lateinit var saveButton: JButton
    lateinit var quitButton: JButton
    lateinit var levelPanel: LevelPanel

    init {
        initComponents()
    }

    private fun initComponents() {

        controlPanel = JPanel()
        removeButton = JButton()
        startButton = JButton()
        saveButton = JButton()
        quitButton = JButton()
        levelPanel = LevelPanel()

        //======== this ========
        preferredSize = Dimension(1280, 720)
        background = Color(187, 187, 187)


        //======== controlPanel ========


        //---- removeButton ----
        removeButton.text = "Remove"

        //---- startButton ----
        startButton.text = "Start!"

        //---- saveButton ----
        saveButton.text = "Save"

        //---- quitButton ----
        quitButton.text = "Quit"
        val controlPanelLayout = GroupLayout(controlPanel)
        controlPanel.layout = controlPanelLayout
        controlPanel.background = Color.black
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup()
                .addGroup(
                    controlPanelLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(276, Short.MAX_VALUE.toInt())
                )
        )
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup()
                .addGroup(
                    controlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                            controlPanelLayout.createParallelGroup()
                                .addComponent(
                                    startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE.toInt()
                                )
                                .addGroup(
                                    controlPanelLayout.createSequentialGroup()
                                        .addGroup(
                                            controlPanelLayout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING,
                                                false
                                            )
                                                .addComponent(
                                                    removeButton,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    68,
                                                    Short.MAX_VALUE.toInt()
                                                )
                                                .addComponent(
                                                    saveButton,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    68,
                                                    Short.MAX_VALUE.toInt()
                                                )
                                                .addComponent(
                                                    quitButton,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    68,
                                                    Short.MAX_VALUE.toInt()
                                                )
                                        )
                                        .addGap(0, 0, Short.MAX_VALUE.toInt())
                                )
                        )
                        .addContainerGap()
                )
        )

        //======== levelPanel ========

        val levelPanelLayout = GroupLayout(levelPanel)
        levelPanel.layout = levelPanelLayout
        levelPanelLayout.setHorizontalGroup(
            levelPanelLayout.createParallelGroup()
                .addGap(0, 1280, Short.MAX_VALUE.toInt())
        )
        levelPanelLayout.setVerticalGroup(
            levelPanelLayout.createParallelGroup()
                .addGap(0, 634, Short.MAX_VALUE.toInt())
        )

        val groupLayout = GroupLayout(this)
        layout = groupLayout
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup()
                .addComponent(
                    controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE.toInt()
                )
                .addComponent(levelPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE.toInt())
        )
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup()
                .addGroup(
                    groupLayout.createSequentialGroup()
                        .addComponent(
                            controlPanel,
                            GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(
                            levelPanel,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            Short.MAX_VALUE.toInt()
                        )
                )
        )


    }

}