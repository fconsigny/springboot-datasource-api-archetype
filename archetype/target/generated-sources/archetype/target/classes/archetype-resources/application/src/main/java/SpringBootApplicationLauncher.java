#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(SpringBootConfiguration.class)
public class SpringBootApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationLauncher.class, args);
    }
}