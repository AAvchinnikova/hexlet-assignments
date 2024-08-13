package exercise.dto;

// BEGIN

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.providers.base.GarmentSize;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
public class GuestCreateDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;

    @FutureOrPresent
    private LocalDate cardValidUntil;

}
// END
