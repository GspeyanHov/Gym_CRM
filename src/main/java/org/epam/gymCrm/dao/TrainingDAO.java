package org.epam.gymCrm.dao;

import java.util.List;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;

public interface TrainingDAO {

    void create(Training training);
    List<Training> selectByType(TrainingType type);

}
