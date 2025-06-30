import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PointTest {

    @Test
    fun `should return correct x and y`() {
        val point = Point(3.0, 4.0)
        assertEquals(3.0, point.getX())
        assertEquals(4.0, point.getY())
    }

    @Test
    fun `should move point by delta`() {
        val point = Point(1.0, 2.0)
        point.move(3.0, 4.0)
        assertEquals(4.0, point.getX())
        assertEquals(6.0, point.getY())
    }

    @Test
    fun `should clone point correctly`() {
        val original = Point(5.0, 7.0)
        val clone = original.clone()

        assertEquals(original.getX(), clone.getX())
        assertEquals(original.getY(), clone.getY())
        assertNotSame(original, clone) // make sure it's a new instance
    }
}
