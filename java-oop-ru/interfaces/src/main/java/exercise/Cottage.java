package exercise;

// BEGIN
public class Cottage implements Home{
   private double area;
   private int floorCount;

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
        int resultCompare = 0;
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
