package org.zjye.math.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.zjye.math.Application;
import org.zjye.math.ScenarioConfig;
import org.zjye.math.ScenarioContext;

@Component
@SpringApplicationConfiguration(classes = { Application.class, ScenarioConfig.class})
public abstract class BaseSteps {

    @Autowired
    protected ScenarioContext scenarioContext;
}
