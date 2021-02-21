package stepdefs;

import io.cucumber.java.en.Given;

public class FirstStepDefs {
    @Given("welcome message")
    public void first_step() {
        System.out.println("Hello, Cucumber, Earth power!");
    }
}
