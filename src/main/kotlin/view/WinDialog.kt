package view


import java.awt.Font
import java.awt.Window
import javax.swing.*


class WinDialog(owner: Window) : JDialog(owner) {

    lateinit var nameField: JTextField
    lateinit var OKButton: JButton
    lateinit var winLabel: JLabel
    lateinit var nameLabel: JLabel

    init {
        initComponents()
    }

    private fun initComponents() {
        nameField = JTextField()
        OKButton = JButton()
        winLabel = JLabel()
        nameLabel = JLabel()

        //======== this ========
        val contentPane = contentPane


        //---- button1 ----
        OKButton.text = "OK"


        //---- winLabel
        //----
        winLabel.text = "You have Won!"
        winLabel.horizontalAlignment = SwingConstants.CENTER
        winLabel.font = winLabel
            .font.deriveFont(
                winLabel
                    .font.style or Font.BOLD, 31f
            )

        //---- nameLabel
        //----
        nameLabel.text = "Please Enter Your Name!"
        nameLabel.horizontalAlignment = SwingConstants.CENTER

        val contentPaneLayout = GroupLayout(contentPane)
        contentPane.layout = contentPaneLayout
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(
                    contentPaneLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(OKButton)
                        .addContainerGap(160, Short.MAX_VALUE.toInt())
                )
                .addGroup(
                    contentPaneLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(
                            contentPaneLayout.createParallelGroup()
                                .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE.toInt())
                                .addComponent(
                                    winLabel,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE.toInt()
                                )
                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE.toInt())
                        )
                        .addGap(74, 74, 74)
                )
        )
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(
                    GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE.toInt())
                        .addGap(18, 18, 18)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(OKButton)
                        .addGap(41, 41, 41)
                )
        )
        pack()
        setLocationRelativeTo(owner)

    }
}