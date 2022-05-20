package models

import java.awt.Graphics
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import javax.swing.Timer

class Level(fileName: String) : Drawable, java.io.Serializable {

    lateinit var movableParticle: MovableParticle
    lateinit var collidables: List<Collidable>
    lateinit var particles: MutableList<Particle>
    lateinit var fileName: String
    lateinit var timer: Timer
    var game: Game? = null



    init {
        load(fileName)
    }

    fun pushParticle(p: Particle) {
        particles.add(p)
    }

    fun popParticle() {
        if (particles.isNotEmpty()) {
            particles.removeLast()
        }
    }

    fun step(deltaTime: Double) {
        val force = sumForces()
        movableParticle.move(force, deltaTime)
        checkCollisions()
        ensureMovableParticleInInside()
    }

    private fun sumForces(): Vector {
        return Vector(0.0, 0.0).apply {
            for (particle in particles) {
                this.add(particle.calculateForce(movableParticle))
            }
        }
    }

    private fun checkCollisions() {
        for (collidable in collidables) {
            if (collidable.didCollide(movableParticle)) {
                timer.stop()
                collidable.onCollide()
            }
        }
    }

    private fun ensureMovableParticleInInside() {
        if (movableParticle.pos.x > 1280 || movableParticle.pos.x < 0 ||
            movableParticle.pos.y > 640 || movableParticle.pos.y < 0
        ) {
            reset()
        }
    }

    fun save(fileName: String) {
        ObjectOutputStream(FileOutputStream(fileName)).also {
            it.writeObject(movableParticle)
            it.writeObject(collidables)
            it.close()
        }
    }

    fun load(fileName: String) {
        particles = mutableListOf()
        this.fileName = fileName
        val ois = ObjectInputStream(FileInputStream(fileName))
        movableParticle = ois.readObject() as MovableParticle
        collidables = ois.readObject() as List<Collidable>
        ois.close()
        initCollidables()
    }

    private fun initCollidables() {
        for (collidable in collidables) {
            collidable.level = this
        }
    }

    fun reset() {
        timer.stop()
        this.load(fileName)
        game?.addTry()
        game?.addToAllParticles(particles.size)
    }

    fun finishLevel() {
        game?.addTry()
        game?.addToAllParticles(particles.size)
        game?.nextLevel()
    }

    override fun draw(g: Graphics) {
        movableParticle.draw(g)
        for (collidable in collidables) (collidable as Rectangle).draw(g)
        for (particle in particles) particle.draw(g)
    }
}