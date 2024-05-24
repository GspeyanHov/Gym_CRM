package org.epam.gymCrm.storage;

import java.util.List;
import lombok.Data;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;

@Data
public class DataWrapper {

    private List<Trainee> trainees;
    private List<Trainer> trainers;
    private List<Training> trainings;

}
