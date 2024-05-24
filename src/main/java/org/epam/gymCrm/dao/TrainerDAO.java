package org.epam.gymCrm.dao;

import java.util.List;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;

public interface TrainerDAO {

    void create(Trainer trainer);
    void update(Trainer trainer);
    Trainer selectById(int id);

}
