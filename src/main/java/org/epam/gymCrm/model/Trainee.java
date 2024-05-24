package org.epam.gymCrm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Trainee extends User {

    @JsonProperty(value="birthdate")
    private LocalDate birthdate;
    private Address address;

}