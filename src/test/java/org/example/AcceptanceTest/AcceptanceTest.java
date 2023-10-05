
package org.example.AcceptanceTest;

        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature",monochrome = true,snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"org.example.AcceptanceTest"})
public class AcceptanceTest {

}