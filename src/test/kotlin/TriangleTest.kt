import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.abs

class TriangleTest {

    @Test
    fun `should create valid triangle and calculate area`() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(4.0, 0.0)
        val p3 = Point(0.0, 3.0)
        val triangle = Triangle(p1, p2, p3)

        val expectedArea = 6.0  // 1/2 * base * height = 1/2 * 4 * 3
        assertEquals(expectedArea, triangle.getArea(), 0.0001)
    }

    @Test
    fun `should move triangle correctly`() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(4.0, 1.0)
        val p3 = Point(1.0, 5.0)
        val triangle = Triangle(p1, p2, p3)

        triangle.move(2.0, 3.0)

        val movedPoints = triangle.getPoints()
        assertEquals(3.0, movedPoints[0].getX())
        assertEquals(4.0, movedPoints[0].getY())
        assertEquals(6.0, movedPoints[1].getX())
        assertEquals(4.0, movedPoints[1].getY())
        assertEquals(3.0, movedPoints[2].getX())
        assertEquals(8.0, movedPoints[2].getY())
    }

    @Test
    fun `should return correct points`() {
        val p1 = Point(2.0, 3.0)
        val p2 = Point(5.0, 3.0)
        val p3 = Point(2.0, 6.0)
        val triangle = Triangle(p1, p2, p3)

        val points = triangle.getPoints()
        assertTrue(points.contains(p1))
        assertTrue(points.contains(p2))
        assertTrue(points.contains(p3))
    }

    @Test
    fun `should throw exception for zero-area triangle`() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 1.0)
        val p3 = Point(2.0, 2.0)  // These points are collinear

        val exception = assertThrows(IllegalArgumentException::class.java) {
            Triangle(p1, p2, p3)
        }

        assertEquals("A triangle cannot have an area of zero (points must not be collinear)", exception.message)
    }
}
