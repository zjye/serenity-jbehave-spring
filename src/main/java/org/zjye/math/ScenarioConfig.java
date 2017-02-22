package org.zjye.math;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ScenarioConfig {

    @Bean
    public ScenarioScope scenarioScope() {
        return new ScenarioScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(ScenarioScope scenarioScope) {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("scenario", scenarioScope);
        return customScopeConfigurer;
    }

    @Bean
    @Scope("scenario")
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

}
