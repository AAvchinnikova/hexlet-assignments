package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) throws IOException {
        String serialFile = Car.serialize(car);
        Files.write(path, serialFile.getBytes());

    }
    public static Car extract(Path path) throws IOException {
        String userialString = Files.readString(path);
        var result = Car.unserialize(userialString);
        return result;
    }
}
// END
