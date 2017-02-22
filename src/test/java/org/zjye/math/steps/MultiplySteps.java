package org.zjye.math.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.zjye.math.Calculator;

import static org.assertj.core.api.Assertions.assertThat;


public class MultiplySteps extends BaseSteps {

    @Autowired
    Calculator calculator;


    @Given("a variable x with value $value")
    public void givenXValue(@Named("value") int value) {
        scenarioContext.add("x", value);
    }


    @Given("a variable y with value $value")
    public void givenAVariableYWithValue2(@Named("value") int value) {
        scenarioContext.add("y", value);
    }

    @When("I multiply x by $value")
    public void whenImultiplyXBy(@Named("value") int value) {
        int x = scenarioContext.get("x");
        int result = calculator.multiply(x, value);
        scenarioContext.add("result", result);
    }

    @Then("result should equal $value")
    public void thenResultshouldBe(@Named("value") int value) {
        int result = scenarioContext.get("result");
        assertThat(result).isEqualTo(value);
    }
}
