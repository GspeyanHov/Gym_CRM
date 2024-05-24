package org.epam.gymCrm;

import java.time.LocalDate;
import lombok.val;
import org.epam.gymCrm.config.AppConfig;
import org.epam.gymCrm.facade.GymCrmFacade;
import org.epam.gymCrm.model.Address;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.storage.InMemoryStorage;
import org.epam.gymCrm.util.UsernamePasswordUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        val context = new AnnotationConfigApplicationContext(AppConfig.class);

        Address address = new Address();
        address.setStreet("jackson.ave");
        address.setCity("Dallas");
        address.setBuilding("Bridge tower");
        address.setBuildingNumber("45/2");

        Trainee trainee = new Trainee();
        trainee.setId(3);
        trainee.setFirstname("Robert");
        trainee.setLastname("Michael");
        trainee.setActive(false);
        trainee.setUsername(UsernamePasswordUtil.generateUsername(trainee.getUsername(), trainee.getLastname()));
        trainee.setPassword(UsernamePasswordUtil.generatePassword());
        trainee.setBirthdate(LocalDate.of(1987, 3, 5));
        trainee.setAddress(address);


        val facade = context.getBean(GymCrmFacade.class);
        facade.saveTrainee(trainee);
        System.out.println(facade.getTraineeById(3));
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