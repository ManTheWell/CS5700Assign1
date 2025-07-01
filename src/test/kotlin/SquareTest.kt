import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SquareTest {

    @Test
    fun `should create square from origin and side length`() {
        val origin = Point(1.0, 1.0)
        val side = 3.0
        val square = Square(origin, side)

        val points = square.getPoints()
        val p1 = points[0]
        val p2 = points[1]

        assertEquals(1.0, p1.getX())
        assertEquals(1.0, p1.getY())
        assertEquals(4.0, p2.getX()) // 1.0 + 3.0
        assertEquals(4.0, p2.getY())
    }

    @Test
    fun `should calculate correct area`() {
        val square = Square(Point(0.0, 0.0), 5.0)
        assertEquals(25.0, square.getArea())
    }

    @Test
    fun `should move square correctly`() {
        val square = Square(Point(2.0, 2.0), 2.0)
        square.move(1.0, 1.0)

        val points = square.getPoints()
        assertEquals(3.0, points[0].getX())
        assertEquals(3.0, points[0].getY())
        assertEquals(5.0, points[1].getX())
        assertEquals(5.0, points[1].getY())
    }

    @Test
    fun `should throw exception if side length is zero`() {
        val ex = assertThrows(IllegalArgumentException::class.java) {
            Square(Point(0.0, 0.0), 0.0)
        }
        assertTrue(ex.message!!.contains("area of zero", ignoreCase = true))
    }
}
