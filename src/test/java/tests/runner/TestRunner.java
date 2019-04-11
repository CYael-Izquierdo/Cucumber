package tests.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
            "pretty",
            "json:target/cucumber.json",
            "junit:target/cucumber-results.xml"},
        features = "src/test/java/tests/features",
        glue = "src/test/java/tests/steps")
public class TestRunner {
    @BeforeClass
    public static void setUp(){

    }

    @AfterClass
    public static void tearDown() {

    }
}

