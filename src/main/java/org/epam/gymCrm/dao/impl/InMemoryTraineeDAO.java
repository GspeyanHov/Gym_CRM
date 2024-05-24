package org.epam.gymCrm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.epam.gymCrm.dao.TraineeDAO;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.util.UsernamePasswordUtil;

public class InMemoryTraineeDAO implements TraineeDAO {

    private final Map<String, Trainee> traineeMap;

    public InMemoryTraineeDAO(Map<String, Trainee> traineeMap) {
        this.traineeMap = traineeMap;
    }

    @Override
    public void create(Trainee trainee) {
        String username = UsernamePasswordUtil.generateUsername(trainee.getFirstname(), trainee.getLastname());
        String password = UsernamePasswordUtil.generatePassword();
        trainee.setUsername(username);
        trainee.setPassword(password);
        trainee.setAddress(trainee.getAddress());
        trainee.setBirthdate(trainee.getBirthdate());
        traineeMap.put(String.valueOf(trainee.getId()), trainee);
    }

    @Override
    public void update(Trainee trainee) {
        if (traineeMap.containsKey(String.valueOf(trainee.getId()))) {
            traineeMap.put(String.valueOf(trainee.getId()), trainee);
        }
    }

    @Override
    public void delete(int id) {
        traineeMap.remove(String.valueOf(id));
    }

    @Override
    public Trainee selectById(int id) {
        return traineeMap.get(String.valueOf(id));
    }

    @Override
    public List<Trainee> listAll() {
        return new ArrayList<>(traineeMap.values());
    }
}
