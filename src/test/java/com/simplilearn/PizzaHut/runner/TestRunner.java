package com.simplilearn.PizzaHut.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/PizzaHut.feature",
    glue = {"com.simplilearn.PizzaHut.setpsdefinitions"},
    plugin = { "pretty",  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    tags = "@Smoke"
)
public class TestRunner {
}