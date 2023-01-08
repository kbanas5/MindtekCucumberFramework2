package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json", "rerun:target/rerun.txt", "pretty"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@RTB-GR2",
        dryRun = false,
        monochrome = false,
        publish = false




)


public class Runner {
}
