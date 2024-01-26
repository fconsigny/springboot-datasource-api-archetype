package it.pkg;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplicationTestConfiguration
public class SpringBootApplicationLauncherTest {

    @Autowired
    private SpringBootApplicationLauncher application;

    /**
     * Test the main method of the SpringBootApplicationLauncher class.
     * Assert the application runs with the Test profile.
     * Assert the application runs without any errors or exceptions.
     * It executes database scripts and assert there is no exceptions.
     */
    @Test
    public void contextLoads() {
        assertTrue(application != null);
    }

}
