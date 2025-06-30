import kotlin.math.sqrt
import kotlin.math.pow

class Line (private val point1: Point, private val point2: Point) {
    init {
        require(!(point1.getX() == point2.getX() && point1.getY() == point2.getY())) {
            "A line cannot have zero length (points must be different)"
        }
    }

    fun getPoints(): List<Point> {
        return listOf(point1, point2)
    }

    fun getSlope(): Double? {
        return if (point1.getX() == point2.getX())
            null
        else if (point1.getX() < point2.getX())
            ((point2.getY() - point1.getY()) / (point2.getX() - point1.getX()))
        else
            ((point1.getY() - point2.getY()) / (point1.getX() - point2.getX()))
    }

    fun getLength(): Double {
        return sqrt( (point1.getX() - point2.getX()).pow(2)  + (point1.getY() - point2.getY()).pow(2) )
    }

    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
    }
}