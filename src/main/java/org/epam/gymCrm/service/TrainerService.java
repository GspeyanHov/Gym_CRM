package org.epam.gymCrm.service;

import org.epam.gymCrm.model.Trainer;

public interface TrainerService {

    void saveTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    Trainer getTrainerById(int id);

}
