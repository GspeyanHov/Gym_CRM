package org.epam.gymCrm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.val;
import org.epam.gymCrm.dao.TrainingDAO;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.util.UsernamePasswordUtil;

public class InMemoryTrainingDAO implements TrainingDAO {

    private static long counter = 0;
    private final Map<String, Training> trainingMap;

    public InMemoryTrainingDAO(Map<String, Training> trainingMap) {
        this.trainingMap = trainingMap;
    }

    @Override
    public void create(Training training) {
        val traineeName = training.getTrainee().getFirstname();
        val traineeLastname = training.getTrainee().getLastname();
        val trainerName = training.getTrainer().getFirstname();
        val trainerLastname = training.getTrainer().getLastname();
        training.getTrainee().setUsername(UsernamePasswordUtil.generateUsername(traineeName, traineeLastname));
        training.getTrainer().setUsername(UsernamePasswordUtil.generateUsername(trainerName, trainerLastname));
        training.getTrainee().setPassword(UsernamePasswordUtil.generatePassword());
        training.getTrainer().setPassword(UsernamePasswordUtil.generatePassword());
        String uniqueId = generateUniqueId();
        trainingMap.put(uniqueId, training);
    }

    @Override
    public List<Training> selectByType(TrainingType type) {
        List<Training> trainingsByType = new ArrayList<>();
        for (Training training : trainingMap.values()) {
            if (training.getType() == type) {
                trainingsByType.add(training);
            }
        }
        return trainingsByType;
    }

    private static synchronized String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        String uniqueId = String.valueOf(timestamp) + counter;
        counter++;
        return uniqueId;
    }
}
