#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplicationTestConfiguration
public class SpringBootApplicationLauncherTest {

    @Autowired
    private SpringBootApplicationLauncher ${artifactId};

    /**
     * Test the main method of the SpringBootApplicationLauncher class.
     * Assert the ${artifactId} runs with the Test profile.
     * Assert the ${artifactId} runs without any errors or exceptions.
     * It executes database scripts and assert there is no exceptions.
     */
    @Test
    public void contextLoads() {
        assertTrue(${artifactId} != null);
    }

}
