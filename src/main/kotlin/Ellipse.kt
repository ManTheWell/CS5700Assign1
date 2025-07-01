import kotlin.math.PI

open class Ellipse(private var center: Point, private var radiusX: Double, private var radiusY: Double) {
    init {
        require(radiusX > 0 && radiusY > 0) {
            "An ellipse cannot have an area of 0 — both radii must be greater than zero"
        }
    }

    fun getCenter(): Point = center.clone()

    fun getRadiusX(): Double = radiusX

    fun getRadiusY(): Double = radiusY

    fun getArea(): Double {
        return PI * radiusX * radiusY
    }

    fun move(deltaX: Double, deltaY: Double) {
        center.move(deltaX, deltaY)
    }
}
