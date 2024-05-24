package org.epam.gymCrm;

import lombok.val;
import org.epam.gymCrm.config.AppConfig;
import org.epam.gymCrm.facade.GymCrmFacade;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.storage.InMemoryStorage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        val context = new AnnotationConfigApplicationContext(AppConfig.class);
        val facade = context.getBean(GymCrmFacade.class);
        System.out.println(facade.getTraineeById(1));
        System.out.println(facade.getAllTrainees());
        System.out.println(facade.getTrainerById(2));
        System.out.println(facade.getTrainingByType(TrainingType.AEROBICS));

        InMemoryStorage storage = context.getBean(InMemoryStorage.class);
        storage.getTraineeMap().forEach((k, v) -> System.out.println(k + ": " + v));
        storage.getTrainerMap().forEach((k, v) -> System.out.println(k + ": " + v));
        storage.getTrainingMap().forEach((k, v) -> System.out.println(k + ": " + v));
        context.close();
    }
}