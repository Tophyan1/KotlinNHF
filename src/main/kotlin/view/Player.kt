package view

import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class Player(var name: String, var score: Int) {

    override fun toString() = "$score $name"

    fun saveToText(fileWriter: FileWriter) {
        fileWriter.write("$score;$name\n")
    }

    fun loadFromText(br: BufferedReader) {
        try {
            br.readLine().split(";").also {
                score = it[0].toInt()
                name = it[1]
            }
        }catch (e: IOException) {
            e.printStackTrace()
            return
        }
    }

    companion object {

        fun readHallOfFame(): MutableList<Player> {
            val hallOfFame = mutableListOf<Player>()
            val br = BufferedReader(FileReader("src/main/resources/HallOfFame.txt"))
            with(br) {
                for (i in 0 until 10) {
                        val p = Player("", 0)
                        p.loadFromText(this)
                        hallOfFame.add(p)
                    }
                close()
            }
            return hallOfFame
        }

        fun writeHallOfFame(hallOfFame: List<Player>) {
            val list = hallOfFame.sortedBy { -it.score }
            try {
                val fileWriter = FileWriter("src/main/resources/HallOfFame.txt")
                with(fileWriter) {
                    for (i in 0 until 10) {
                        list[i].saveToText(fileWriter)
                    }
                    close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}