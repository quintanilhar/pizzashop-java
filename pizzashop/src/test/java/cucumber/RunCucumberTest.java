package cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "summary"},
        strict = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunCucumberTest {
}
