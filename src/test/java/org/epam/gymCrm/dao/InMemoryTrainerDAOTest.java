package org.epam.gymCrm.dao;

import java.util.HashMap;
import java.util.Map;
import org.epam.gymCrm.dao.impl.InMemoryTrainerDAO;
import org.epam.gymCrm.model.Trainer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryTrainerDAOTest {

    private InMemoryTrainerDAO inMemoryTrainerDAO;
    private Map<String, Trainer> trainerMap;

    @BeforeEach
    void setUp() {
        trainerMap = new HashMap<>();
        inMemoryTrainerDAO = new InMemoryTrainerDAO(trainerMap);
    }

    @Test
    void testCreate() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstname("John");
        trainer.setLastname("Doe");
        trainer.setSpecialization("Fitness");

        inMemoryTrainerDAO.create(trainer);

        Trainer storedTrainer = trainerMap.get("1");
        assertNotNull(storedTrainer, "Trainer should be stored in the map");
        assertEquals("John.Doe", storedTrainer.getUsername(), "Username should be correctly generated");
        assertNotNull(storedTrainer.getPassword(), "Password should be generated");
        assertEquals("Fitness", storedTrainer.getSpecialization(), "Specialty should be correctly set");
    }

    @Test
    void testUpdate() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstname("John");
        trainer.setLastname("Doe");
        trainerMap.put("1", trainer);

        trainer.setFirstname("Jane");
        trainer.setLastname("Smith");
        inMemoryTrainerDAO.update(trainer);

        Trainer updatedTrainer = trainerMap.get("1");
        assertNotNull(updatedTrainer, "Trainer should still be in the map after update");
        assertEquals("Jane", updatedTrainer.getFirstname(), "First name should be updated");
        assertEquals("Smith", updatedTrainer.getLastname(), "Last name should be updated");
    }

    @Test
    void testSelectById() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainerMap.put("1", trainer);

        Trainer selectedTrainer = inMemoryTrainerDAO.selectById(1);
        assertNotNull(selectedTrainer, "Trainer should be retrievable by ID");
        assertEquals(trainer, selectedTrainer, "Retrieved trainer should match the stored trainer");
    }
}
