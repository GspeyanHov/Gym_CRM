package org.epam.gymCrm.config;

import java.util.Objects;
import org.epam.gymCrm.dao.TraineeDAO;
import org.epam.gymCrm.dao.TrainerDAO;
import org.epam.gymCrm.dao.TrainingDAO;
import org.epam.gymCrm.dao.impl.InMemoryTraineeDAO;
import org.epam.gymCrm.dao.impl.InMemoryTrainerDAO;
import org.epam.gymCrm.dao.impl.InMemoryTrainingDAO;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import org.epam.gymCrm.service.impl.TraineeServiceImpl;
import org.epam.gymCrm.service.impl.TrainerServiceImpl;
import org.epam.gymCrm.service.impl.TrainingServiceImpl;
import org.epam.gymCrm.storage.InMemoryStorage;
import org.epam.gymCrm.storage.StorageInitializer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "org.epam.gymCrm")
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Bean
    @Lazy
    public InMemoryStorage inMemoryStorage() {
        return new InMemoryStorage();
    }

    @Bean
    @Lazy
    public TraineeDAO traineeDAO(InMemoryStorage storage) {
        return new InMemoryTraineeDAO(storage.getTraineeMap());
    }

    @Bean
    @Lazy
    public TrainerDAO trainerDAO(InMemoryStorage storage) {
        return new InMemoryTrainerDAO(storage.getTrainerMap());
    }

    @Bean
    @Lazy
    public TrainingDAO trainingDAO(InMemoryStorage storage) {
        return new InMemoryTrainingDAO(storage.getTrainingMap());
    }

    public TrainerService trainerService() {
        return new TrainerServiceImpl(trainerDAO(inMemoryStorage()));
    }

    public TraineeService traineeService() {
        return new TraineeServiceImpl(traineeDAO(inMemoryStorage()));
    }

    public TrainingService trainingService() {
        return new TrainingServiceImpl(trainingDAO(inMemoryStorage()));
    }

    @Bean
    @Lazy
    public StorageInitializer storageInitializer() {
        return new StorageInitializer(traineeService(), trainerService(), trainingService());
    }

    @Bean
    @SuppressWarnings(value = "deprecation")
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        propertyPlaceholderConfigurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return propertyPlaceholderConfigurer;
    }
}
