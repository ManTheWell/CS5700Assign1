import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI

class CircleTest {

    @Test
    fun `should create valid circle and calculate area`() {
        val center = Point(0.0, 0.0)
        val circle = Circle(center, 3.0)

        val expectedArea = PI * 3.0 * 3.0
        assertEquals(expectedArea, circle.getArea(), 0.0001)
    }

    @Test
    fun `should return correct radius`() {
        val circle = Circle(Point(1.0, 1.0), 5.0)
        assertEquals(5.0, circle.getRadius())
        assertEquals(5.0, circle.getRadiusX())
        assertEquals(5.0, circle.getRadiusY())
    }

    @Test
    fun `should move circle correctly`() {
        val center = Point(2.0, 2.0)
        val circle = Circle(center, 4.0)

        circle.move(3.0, -1.0)
        val movedCenter = circle.getCenter()

        assertEquals(5.0, movedCenter.getX())
        assertEquals(1.0, movedCenter.getY())
    }

    @Test
    fun `getCenter should return a copy`() {
        val circle = Circle(Point(0.0, 0.0), 2.0)
        val originalCenter = circle.getCenter()
        originalCenter.move(10.0, 10.0)

        val actualCenter = circle.getCenter()
        assertEquals(0.0, actualCenter.getX())
        assertEquals(0.0, actualCenter.getY())
    }

    @Test
    fun `should throw exception for zero or negative radius`() {
        val ex1 = assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), 0.0)
        }

        val ex2 = assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), -5.0)
        }

        assertTrue(ex1.message!!.contains("greater than zero"))
        assertTrue(ex2.message!!.contains("greater than zero"))
    }
}
