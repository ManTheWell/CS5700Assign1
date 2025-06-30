import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SquareTest {

    @Test
    fun `should create valid square and calculate area`() {
        val p1 = Point(2.0, 2.0)
        val p2 = Point(5.0, 5.0)
        val square = Square(p1, p2)

        assertEquals(9.0, square.getArea(), 0.0001)
    }

    @Test
    fun `should move square correctly`() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(3.0, 3.0)
        val square = Square(p1, p2)

        square.move(2.0, 2.0)
        val movedPoints = square.getPoints()

        assertEquals(2.0, movedPoints[0].getX())
        assertEquals(2.0, movedPoints[0].getY())
        assertEquals(5.0, movedPoints[1].getX())
        assertEquals(5.0, movedPoints[1].getY())
    }

    @Test
    fun `should return same two points`() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(4.0, 4.0)
        val square = Square(p1, p2)

        val points = square.getPoints()
        assertTrue(points.contains(p1))
        assertTrue(points.contains(p2))
    }

    @Test
    fun `should throw exception for unequal side lengths`() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(4.0, 3.0) // width != height

        val exception = assertThrows(IllegalArgumentException::class.java) {
            Square(p1, p2)
        }

        assertTrue(exception.message!!.contains("equal width and height"))
    }
}

