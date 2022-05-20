package models

interface Collidable {

    fun onCollide()

    fun didCollide(p: MovableParticle): Boolean

    var level: Level?
}