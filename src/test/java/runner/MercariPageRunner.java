package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Slf4j
@CucumberOptions(tags = {"@Mercari_App"},
    glue = {"stepdefs"},
    plugin = {"pretty",
        "html:target/cucumber-reports/mercaripage/cucumber-pretty",
        "json:target/json-cucumber-reports/mercaripage/cukejson.json",
        "testng:target/testng-cucumber-reports/mercaripage/cuketestng.xml"},
    features = {"src/test/resources/features/MercariPage"})
public class MercariPageRunner extends AbstractTestNGCucumberTests {

  @BeforeClass
  public static void before() {
    log.info("Mercari App Process Started");
  }

  @AfterClass
  public static void after() {
    log.info("Mercari App Process Completed");
  }

}
