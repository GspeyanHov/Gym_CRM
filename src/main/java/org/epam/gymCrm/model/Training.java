package org.epam.gymCrm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Training {

    private Trainee trainee;
    private Trainer trainer;
    @JsonProperty(value="trainingName")
    private String trainingName;
    private TrainingType type;
    @JsonProperty(value="trainingDate")
    private LocalDateTime trainingDate;
    @JsonProperty(value="duration")
    private double duration;

}