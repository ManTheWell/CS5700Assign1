import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RectangleTest {

    @Test
    fun `should calculate correct area`() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(4.0, 5.0)
        val rect = Rectangle(p1, p2)

        val expectedArea = kotlin.math.abs((1.0 - 4.0) * (1.0 - 5.0)) // 3 * 4 = 12
        assertEquals(expectedArea, rect.getArea())
    }

    @Test
    fun `should move both points correctly`() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(2.0, 2.0)
        val rect = Rectangle(p1, p2)

        rect.move(1.0, 1.0)
        val movedPoints = rect.getPoints()

        assertEquals(1.0, movedPoints[0].getX())
        assertEquals(1.0, movedPoints[0].getY())
        assertEquals(3.0, movedPoints[1].getX())
        assertEquals(3.0, movedPoints[1].getY())
    }

    @Test
    fun `should return the same two points`() {
        val p1 = Point(2.0, 3.0)
        val p2 = Point(5.0, 7.0)
        val rect = Rectangle(p1, p2)

        val points = rect.getPoints()
        assertTrue(points.contains(p1))
        assertTrue(points.contains(p2))
        assertEquals(2, points.size)
    }

    @Test
    fun `should throw exception for zero-area rectangle`() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(1.0, 1.0)

        val exception = assertThrows(IllegalArgumentException::class.java) {
            Rectangle(p1, p2)
        }

        assertEquals("A rectangle cannot have an area of zero (points must be different)", exception.message)
    }
}
