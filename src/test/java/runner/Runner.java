package runner;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CrearGuiasFP/CrearGuiasFP.feature",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
        //tags = "@integracionContinua"
)

public class Runner {}



