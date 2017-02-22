package org.zjye.math.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.zjye.math.*;


@Component
@SpringApplicationConfiguration(classes = { ApplicationToTest.class, ScenarioConfig.class})
public class TestSteps {

    @Autowired
    ScenarioContext scenarioContext;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    ApplicationService applicationService;

    private int result;

    @Given("a variable x with value $value")
    public void givenXValue(@Named("value") int value) {
        scenarioContext.add("x", value);
    }

    @When("I multiply x by $value")
    public void whenImultiplyXBy(@Named("value") int value) {
        int x = scenarioContext.get("x");

        result = applicationService.multiply(x, value);
    }

    @Then("result should equal $value")
    public void thenXshouldBe(@Named("value") int value) {
        if (value != result)
            throw new RuntimeException("result is " + result + ", but should be " + value);
    }
}
