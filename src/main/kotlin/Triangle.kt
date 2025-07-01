import kotlin.math.abs
import kotlin.math.sqrt

class Triangle(private var point1: Point, private var point2: Point, private var point3: Point) {
    init {
        require(!hasZeroArea()) {
            "A triangle cannot have an area of zero (points must not be collinear)"
        }
    }

    // Get the three points of the triangle
    fun getPoints(): List<Point> {
        return listOf(point1, point2, point3)
    }

    // Calculate the area using Heron's formula
    fun getArea(): Double {
        val a = distance(point1, point2)
        val b = distance(point2, point3)
        val c = distance(point3, point1)

        val s = (a + b + c) / 2  // semi-perimeter
        return sqrt(s * (s - a) * (s - b) * (s - c)) // Heron's formula
    }

    // Move all three points of the triangle by deltaX and deltaY
    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
        point3.move(deltaX, deltaY)
    }

    // Check if the area is zero (points are collinear)
    private fun hasZeroArea(): Boolean {
        val a = distance(point1, point2)
        val b = distance(point2, point3)
        val c = distance(point3, point1)

        return a + b <= c || a + c <= b || b + c <= a  // Check if points are collinear
    }

    // Calculate the distance between two points
    private fun distance(p1: Point, p2: Point): Double {
        val dx = p2.getX() - p1.getX()
        val dy = p2.getY() - p1.getY()
        return sqrt(dx * dx + dy * dy)
    }
}
