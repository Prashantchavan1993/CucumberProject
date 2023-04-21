package com.bnpadvisor.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.bnpadvisor.stepdefinitions",
        plugin = {"pretty", "html:src/cucumber.html"}
//        tags = "@Dummy"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
