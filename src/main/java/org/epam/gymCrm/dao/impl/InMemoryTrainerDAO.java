package org.epam.gymCrm.dao.impl;

import java.util.Map;
import org.epam.gymCrm.dao.TrainerDAO;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.util.UsernamePasswordUtil;

public class InMemoryTrainerDAO implements TrainerDAO {

    private final Map<String, Trainer> trainerMap;

    public InMemoryTrainerDAO(Map<String, Trainer> trainerMap) {
        this.trainerMap = trainerMap;
    }

    @Override
    public void create(Trainer trainer) {
        String username = UsernamePasswordUtil.generateUsername(trainer.getFirstname(), trainer.getLastname());
        String password = UsernamePasswordUtil.generatePassword();
        trainer.setUsername(username);
        trainer.setPassword(password);
        trainerMap.put(String.valueOf(trainer.getId()), trainer);
    }

    @Override
    public void update(Trainer trainer) {
        trainerMap.put(String.valueOf(trainer.getId()), trainer);
    }

    @Override
    public Trainer selectById(int id) {
        return trainerMap.get(String.valueOf(id));
    }
}
