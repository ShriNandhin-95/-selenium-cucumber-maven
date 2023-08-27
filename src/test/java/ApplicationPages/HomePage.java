package ApplicationPages;

import static com.sample.assesment.Util.ApplicationConstants.BROWSING_HISTORY;
import static com.sample.assesment.Util.ApplicationConstants.BROWSING_HISTORY_LATEST;
import static com.sample.assesment.Util.ApplicationConstants.BROWSING_HISTORY_LIST;
import static com.sample.assesment.Util.ApplicationConstants.CATEGORIES;
import static com.sample.assesment.Util.ApplicationConstants.CATEGORY_ID_3;
import static com.sample.assesment.Util.ApplicationConstants.CATEGORY_ID_5;
import static com.sample.assesment.Util.ApplicationConstants.CATEGORY_ID_54;
import static com.sample.assesment.Util.ApplicationConstants.CATEGORY_ID_72;
import static com.sample.assesment.Util.ApplicationConstants.CHECKBOX;
import static com.sample.assesment.Util.ApplicationConstants.CHECKBOX_NAME;
import static com.sample.assesment.Util.ApplicationConstants.FIRST_SELECT_OPTION;
import static com.sample.assesment.Util.ApplicationConstants.SEARCH;
import static com.sample.assesment.Util.ApplicationConstants.SEARCH_ID_674;
import static com.sample.assesment.Util.ApplicationConstants.SEARCH_ID_966;
import static com.sample.assesment.Util.ApplicationConstants.SEARCH_JAVASCRIPT;
import static com.sample.assesment.Util.ApplicationConstants.SECOND_SELECT_OPTION;
import static com.sample.assesment.Util.ApplicationConstants.XPATH;
import static com.sample.assesment.WebConnector.webconnector.driver;

import com.sample.assesment.Util.ApplicationConstants;
import com.sample.assesment.WebConnector.webconnector;
import java.time.Duration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Slf4j
public class HomePage {

  webconnector wc = new webconnector();

  public HomePage() {
    PageFactory.initElements(driver, this);
  }

  public void open() {
    wc.createLocalDriver();
  }

  public void close() {
    wc.closeDriver();
  }

  public void goToHomePage() {
    driver.get(wc.getProperty(ApplicationConstants.URL));

    wc.setImplicitWaitTimeout(Duration.ofSeconds(40));
    wc.setPageLoadTimeOut(Duration.ofSeconds(40));
  }

  public void selectSpecifiedUserCategory() {

    new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(
            StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(wc.getProperty(SEARCH))));
    wc.findByElement(wc.getProperty(SEARCH), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORIES), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORY_ID_5), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORY_ID_72), XPATH).click();

    wc.findByElement(wc.getProperty(SEARCH_ID_674), XPATH).click();
  }

  public void searchSelectConditionValidation() {
    Select select = new Select(wc.findByElement(wc.getProperty(FIRST_SELECT_OPTION), XPATH));
    WebElement option = select.getFirstSelectedOption();

    String defaultItem = option.getText();

    Assert.assertEquals("本・音楽・ゲーム", defaultItem);

    Select select1 = new Select(wc.findByElement(wc.getProperty(SECOND_SELECT_OPTION), XPATH));
    WebElement option1 = select1.getFirstSelectedOption();

    String defaultItem1 = option1.getText();

    Assert.assertEquals("本", defaultItem1);

    WebElement checkBox = wc.findByElement(wc.getProperty(CHECKBOX), XPATH);

    if (checkBox.isSelected()) {
      Assert.assertTrue(checkBox.isSelected(), "Checkbox is selected");
      log.info("Checkbox is selected");
    } else {
      Assert.assertTrue(checkBox.isSelected(), "Checkbox is not selected");
      log.info("Checkbox is not selected");
    }

    WebElement checkBox_name = wc.findByElement(wc.getProperty(CHECKBOX_NAME), XPATH);
    String name = checkBox_name.getText();

    Assert.assertEquals(name, "コンピュータ/IT");

    log.info("Test Passed");
  }

  public void selectSpecifiedUserCategoryForBabyKids() throws Throwable {

    new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(wc.getProperty(SEARCH))));
    wc.findByElement(wc.getProperty(SEARCH), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORIES), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORY_ID_3), XPATH).click();

    wc.findByElement(wc.getProperty(CATEGORY_ID_54), XPATH).click();

    wc.findByElement(wc.getProperty(SEARCH_ID_966), XPATH).click();

  }

  public void verifyBrowsingHistory() throws Throwable {

    new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(wc.getProperty(SEARCH))));
    wc.findByElement(wc.getProperty(SEARCH), XPATH).click();

    wc.findByElement(wc.getProperty(BROWSING_HISTORY), XPATH).isDisplayed();

    List<WebElement> browserHistory = wc.findByElements(wc.getProperty(BROWSING_HISTORY_LIST),
        XPATH);
    int size = browserHistory.size();
    Assert.assertEquals(size, 2);
    WebElement ele1 = browserHistory.get(0);

    String latestBrowsingHistory1 = ele1.getText();
    Assert.assertEquals(latestBrowsingHistory1, "コンピュータ/IT");

    WebElement latestBrowsingHistory = wc.findByElement(wc.getProperty(BROWSING_HISTORY_LATEST),
        XPATH);
    String latestBrowsingHistoryValue = latestBrowsingHistory.getText();

    Assert.assertEquals(latestBrowsingHistoryValue, "コンピュータ/IT");

    latestBrowsingHistory.click();

  }

  public void sendUserActionAsJavaScript() {

    log.info("Inside Step - user send javascript in search bar");

    wc.findByElement(wc.getProperty(SEARCH), XPATH).sendKeys("javascript");

    wc.findByElement(wc.getProperty(SEARCH_JAVASCRIPT), XPATH).click();

  }

  public void verify_the_3_browsing_history_is_showing_correctly() {

    new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(wc.getProperty(SEARCH))));
    wc.findByElement(wc.getProperty(SEARCH), XPATH).click();

    wc.findByElement(wc.getProperty(BROWSING_HISTORY), XPATH).isDisplayed();

    List<WebElement> browserHistory = wc.findByElements(wc.getProperty(BROWSING_HISTORY_LIST),
        XPATH);
    int size = browserHistory.size();
    Assert.assertEquals(size, 3);
    Assert.assertEquals(browserHistory.get(0).getText(), "javascript, コンピュータ/IT");

  }

}
