package org.epam.gymCrm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Trainer extends User {

    @JsonProperty(value="specialization")
    private String specialization;

}