package it.pkg.controllers.greetings;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    @GetMapping
    public String getGreetings() {
        return "Hello";
    }

    @GetMapping(path = "/{name}")
    public String getGreetingsByName(@PathVariable final String name) {
        return "Hello " + name;
    }

}
