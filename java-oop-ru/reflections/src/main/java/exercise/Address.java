package exercise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

class Address {
    // BEGIN
    @NotNull
    // END
    private String country;

    // BEGIN
    @NotNull
    // END
    private String city;

    // BEGIN
    @NotNull
    // END
    private String street;

    // BEGIN
    @NotNull
    // END
    private String houseNumber;

    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

}
