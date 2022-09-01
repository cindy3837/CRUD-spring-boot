package com.example.service.app.behavior;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/behavior",
        plugin = {"pretty", "html:target/cucumber/behavior.html"},
        stepNotifications = true,
        publish = true,
        extraGlue = "com.example.service.app.cucumber")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BehaviorTest {
}
