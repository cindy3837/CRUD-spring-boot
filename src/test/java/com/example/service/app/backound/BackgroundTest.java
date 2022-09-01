package com.example.service.app.backound;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/background",
        plugin = {"pretty", "html:target/cucumber/background.html"},
        stepNotifications = true,
        publish = true,
        extraGlue = "com.example.service.app.cucumber")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BackgroundTest {
}
