package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> listHome, int n) {
        return listHome.stream().sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n).map(Object::toString).collect(Collectors.toList());
    }
}
// END
