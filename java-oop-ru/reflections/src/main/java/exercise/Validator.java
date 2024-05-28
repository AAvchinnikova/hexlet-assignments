package exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                var stringfield = field.getName();
                field.setAccessible(true);
                String value = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && (value == null)) {
                    result.add(stringfield);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
// END
