import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI

class EllipseTest {

    @Test
    fun `should create valid ellipse and calculate area`() {
        val center = Point(0.0, 0.0)
        val ellipse = Ellipse(center, 3.0, 2.0)

        val expectedArea = PI * 3.0 * 2.0
        assertEquals(expectedArea, ellipse.getArea(), 0.0001)
    }

    @Test
    fun `should move ellipse center correctly`() {
        val center = Point(1.0, 1.0)
        val ellipse = Ellipse(center, 4.0, 2.0)

        ellipse.move(2.0, 3.0)
        val movedCenter = ellipse.getCenter()

        assertEquals(3.0, movedCenter.getX())
        assertEquals(4.0, movedCenter.getY())
    }

    @Test
    fun `should return correct center and radii`() {
        val center = Point(5.0, 5.0)
        val ellipse = Ellipse(center, 6.0, 4.0)

        val resultCenter = ellipse.getCenter()
        assertEquals(5.0, resultCenter.getX())
        assertEquals(5.0, resultCenter.getY())
        assertEquals(6.0, ellipse.getRadiusX())
        assertEquals(4.0, ellipse.getRadiusY())
    }

    @Test
    fun `should throw exception for zero or negative radii`() {
        val center = Point(0.0, 0.0)

        val ex1 = assertThrows(IllegalArgumentException::class.java) {
            Ellipse(center, 0.0, 2.0)
        }
        assertTrue(ex1.message!!.contains("area of 0"))

        val ex2 = assertThrows(IllegalArgumentException::class.java) {
            Ellipse(center, 2.0, 0.0)
        }
        assertTrue(ex2.message!!.contains("area of 0"))

        val ex3 = assertThrows(IllegalArgumentException::class.java) {
            Ellipse(center, -1.0, 2.0)
        }
        assertTrue(ex3.message!!.contains("area of 0"))

        val ex4 = assertThrows(IllegalArgumentException::class.java) {
            Ellipse(center, 1.0, -2.0)
        }
        assertTrue(ex4.message!!.contains("area of 0"))
    }

    @Test
    fun `getCenter should return a copy`() {
        val center = Point(1.0, 1.0)
        val ellipse = Ellipse(center, 2.0, 2.0)

        val c = ellipse.getCenter()
        c.move(100.0, 100.0)

        val original = ellipse.getCenter()
        assertEquals(1.0, original.getX())
        assertEquals(1.0, original.getY())
    }
}
