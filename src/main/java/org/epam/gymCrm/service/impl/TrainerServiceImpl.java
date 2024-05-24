package org.epam.gymCrm.service.impl;

import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.epam.gymCrm.dao.TrainerDAO;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.service.TrainerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final Logger logger = Logger.getLogger(TrainerServiceImpl.class.getName());
    private final TrainerDAO trainerDAO;

    @Override
    public void saveTrainer(Trainer trainer) {
        trainerDAO.create(trainer);
        logger.info("Trainer " + trainer.getFirstname() + " " + trainer.getLastname());
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerDAO.update(trainer);
        logger.info("Trainer " + trainer.getFirstname() + " " + trainer.getLastname());
    }

    @Override
    public Trainer getTrainerById(int id) {
        logger.info("Get trainer by id " + id);
        return trainerDAO.selectById(Math.toIntExact(id));
    }
}
