import kotlin.math.sqrt

class Rectangle(var point1: Point, var point2: Point) {
    init {
        require(!(point1.getX() == point2.getX() && point1.getY() == point2.getY())) {
            "A rectangle cannot have an area of zero (points must be different)"
        }
    }

    fun getPoints(): List<Point> {
        return listOf(point1, point2)
    }

    fun getArea(): Double {
        return kotlin.math.abs( (point1.getX() - point2.getX()) * (point1.getY() - point2.getY()) )
    }

    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
    }
}