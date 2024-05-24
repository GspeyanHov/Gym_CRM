package org.epam.gymCrm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Address {

    @JsonProperty(value="city")
    private String city;
    @JsonProperty(value="street")
    private String street;
    @JsonProperty(value="building")
    private String building;
    @JsonProperty(value="buildingNumber")
    private String buildingNumber;
}
