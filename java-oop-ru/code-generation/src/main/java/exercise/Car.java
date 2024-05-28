package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// BEGIN
@Getter
@Setter
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //Car car = new Car(getId(), getBrand(), getModel(), getColor(), getOwner());
        return mapper.writeValueAsString(car);
    }

    public static Car unserialize(String jsonCar) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonCar, Car.class);
    }
    // END
}
