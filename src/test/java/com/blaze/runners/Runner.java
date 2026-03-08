package com.blaze.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

           features = "src/test/resources/blaze/blaze.feature",
           glue = "com.blaze.stepDefinition",
           dryRun = false,
           tags = "@regression or @negative",
           plugin = {
                   "pretty",
                   "html:target/uiReport.html","rerun:target/uiFailedTests.txt"
           }
)


public class Runner {
}
