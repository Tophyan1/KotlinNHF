package models

import java.awt.Graphics
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class Game: Drawable, java.io.Serializable {

    lateinit var levels: List<Level>
    var currentLevelIndex: Int = 0
    var isGameOver: Boolean = false
    var tries: Int = 0
    var numberOfAllParticles: Int = 0
    init {
        setUpLevels()
    }

    private fun setUpLevels() {
        levels = listOf(
            Level("src/main/resources/levels/Level_1.dat").apply { this.game = this@Game },
            Level("src/main/resources/levels/Level_2.dat").apply { this.game = this@Game },
            Level("src/main/resources/levels/Level_3.dat").apply { this.game = this@Game },
            Level("src/main/resources/levels/Level_4.dat").apply { this.game = this@Game },
            Level("src/main/resources/levels/Level_5.dat").apply { this.game = this@Game }
        )
    }

    fun step(deltaTime: Double) {
        levels[currentLevelIndex].step(deltaTime)
    }

    private fun hasMoreLevels() = currentLevelIndex < levels.size - 1

    fun save(fileName: String) {
        ObjectOutputStream(FileOutputStream(fileName)).also {
            it.writeObject(currentLevelIndex)
            it.writeObject(tries)
            it.writeObject(numberOfAllParticles)
            it.close()
        }
    }

    fun load(fileName: String) {
        val ois = ObjectInputStream(FileInputStream(fileName))
        with(ois) {
            currentLevelIndex = readObject() as Int
            tries = readObject() as Int
            numberOfAllParticles = readObject() as Int
            close()
        }
        setUpLevels()
        isGameOver = false
    }

    fun addTry() {
        tries += 1
    }

    fun addToAllParticles(number: Int) {
        numberOfAllParticles += number
    }

    fun nextLevel() {
        when {
            hasMoreLevels() -> currentLevelIndex++
            else -> isGameOver = true
        }
    }

    fun currentLevel() = levels[currentLevelIndex]

    fun getScore() =  (50 / tries) * (30000 + (210 - numberOfAllParticles) * 500)

    override fun draw(g: Graphics) {
        levels[currentLevelIndex].draw(g)
    }
}
