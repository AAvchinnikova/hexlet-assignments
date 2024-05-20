package exercise;

// BEGIN
public class Cottage implements Home{
   private final double area;
   private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home anotherHome) {
        int resultCompare;
        if (getArea() > anotherHome.getArea()) {
            resultCompare = 1;
        } else if (getArea() == anotherHome.getArea()) {
            resultCompare = 0;
        } else {
            resultCompare = -1;
        }
        return resultCompare;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
