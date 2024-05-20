package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
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
        return "Квартира площадью " + getArea() + " метров на " + floor +" этаже";
    }
}
// END
