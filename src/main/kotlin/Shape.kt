abstract class Shape {
    abstract fun getPoints()
    abstract fun getArea(): Double
    abstract fun move(deltaX: Double, deltaY: Double): Void
}