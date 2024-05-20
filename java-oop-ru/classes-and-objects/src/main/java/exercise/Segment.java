package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private  Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        int middleX = (beginPoint.getX() + endPoint.getX()) / 2;
        int middleY = (beginPoint.getY() + endPoint.getY()) / 2;
        Point result = new Point(middleX, middleY);
        return result;
    }
}
// END