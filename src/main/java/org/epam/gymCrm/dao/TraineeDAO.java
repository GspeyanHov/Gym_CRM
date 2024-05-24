package org.epam.gymCrm.dao;

import java.util.List;
import org.epam.gymCrm.model.Trainee;

public interface TraineeDAO {

    void create(Trainee trainee);
    void update(Trainee trainee);
    void delete(int id);
    Trainee selectById(int id);
    List<Trainee> listAll();

}
