class Square(point1: Point, point2: Point) : Rectangle(point1, point2) {
    init {
        val width = kotlin.math.abs(point1.getX() - point2.getX())
        val height = kotlin.math.abs(point1.getY() - point2.getY())

        require(width == height) {
            "A square must have equal width and height. Got width=$width, height=$height"
        }
    }

    constructor(origin: Point, sideLength: Double) : this(
        origin,
        Point(origin.getX() + sideLength, origin.getY() + sideLength)
    )
}
