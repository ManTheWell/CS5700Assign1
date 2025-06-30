import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LineTest {
    @Test
    fun `should calculate correct length`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        assertEquals(5.0, line.getLength(), 0.0001)
    }

    @Test
    fun `should calculate correct slope`() {
        val line = Line(Point(1.0, 2.0), Point(3.0, 6.0))
        assertEquals(2.0, line.getSlope())
    }

    @Test
    fun `should return null slope for vertical line`() {
        val line = Line(Point(2.0, 1.0), Point(2.0, 5.0))
        assertNull(line.getSlope())
    }

    @Test
    fun `should move both points correctly`() {
        val line = Line(Point(1.0, 1.0), Point(4.0, 5.0))
        line.move(2.0, 3.0)
        val points = line.getPoints()
        val p1 = points[0]
        val p2 = points[1]

        assertEquals(3.0, p1.getX(), 0.0001)
        assertEquals(4.0, p1.getY(), 0.0001)

        assertEquals(6.0, p2.getX(), 0.0001)
        assertEquals(8.0, p2.getY(), 0.0001)
    }

    @Test
    fun `should throw exception for zero-length line`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Line(Point(1.0, 1.0), Point(1.0, 1.0))
        }
        assertEquals("A line cannot have zero length (points must be different)", exception.message)
    }
}