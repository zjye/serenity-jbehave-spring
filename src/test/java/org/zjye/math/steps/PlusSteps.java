package org.zjye.math.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.zjye.math.Calculator;

public class PlusSteps extends BaseSteps {
    @Autowired
    Calculator calculator;

    @When("I add x and y")
    public void whenIAddXAndY() {
        int x = scenarioContext.get("x");
        int y = scenarioContext.get("y");

        int result = calculator.plus(x, y);
        scenarioContext.add("result", result);
    }

}
