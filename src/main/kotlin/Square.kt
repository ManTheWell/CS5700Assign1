class Square(origin: Point, sideLength: Double) :
    Rectangle(origin, Point(origin.getX() + sideLength, origin.getY() + sideLength))
