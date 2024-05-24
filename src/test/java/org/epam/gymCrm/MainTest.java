package org.epam.gymCrm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.epam.gymCrm.config.AppConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    @Test
    void testMainOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Main.main(new String[]{});
        }
        System.setOut(System.out);
        String output = outputStream.toString();

        assertTrue(output.contains("Trainee"));
        assertTrue(output.contains("Trainer"));
        assertTrue(output.contains("Training"));
    }
}
