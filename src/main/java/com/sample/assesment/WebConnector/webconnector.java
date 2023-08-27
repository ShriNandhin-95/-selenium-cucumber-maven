package com.sample.assesment.WebConnector;

import static com.sample.assesment.Util.ApplicationConstants.CLASSNAME;
import static com.sample.assesment.Util.ApplicationConstants.CSS;
import static com.sample.assesment.Util.ApplicationConstants.ID;
import static com.sample.assesment.Util.ApplicationConstants.LINKTEXT;
import static com.sample.assesment.Util.ApplicationConstants.NAME;
import static com.sample.assesment.Util.ApplicationConstants.PARTIALLINKTEXT;
import static com.sample.assesment.Util.ApplicationConstants.TAGNAME;
import static com.sample.assesment.Util.ApplicationConstants.XPATH;

import com.sample.assesment.Util.ApplicationConstants;
import com.sample.assesment.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;

public class webconnector<V> {

  public final static Duration IMPLICIT_WAIT_TIMEOUT = Duration.ofSeconds(40);
  public final static Duration SCRIPT_WAIT_TIMEOUT = Duration.ofSeconds(40);
  public final static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(40);
  public final static Duration POLLING_SECONDS = Duration.ofSeconds(5);
  public static WebDriver driver = null;
  public static Properties prop = new Properties();
  public SessionId session = null;

  public webconnector() {
    try {
      prop.load(new FileInputStream("./src/test/resources/config/application.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getProperty(String key) {
    return prop.getProperty(key);
  }

  public void setDriver(WebDriver driver) {
    webconnector.driver = driver;
  }

  public WebDriver createLocalDriver() {
    DriverType driverType = DriverType.valueOf(getProperty(ApplicationConstants.HOMEPAGE_BROWSER));
    switch (driverType) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      case EDGE:
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;
      case SAFARI:
        driver = new SafariDriver();
        break;
      default:
        throw new IllegalArgumentException("Browser \"" + driverType + "\" isn't supported.");
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT);
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
    driver.manage().timeouts().setScriptTimeout(SCRIPT_WAIT_TIMEOUT);

    return driver;
  }

  public void setImplicitWaitTimeout(Duration duration) {
    duration = null != duration ? duration : IMPLICIT_WAIT_TIMEOUT;
    driver.manage().timeouts().implicitlyWait(duration);
  }

  public void setPageLoadTimeOut(Duration duration) {
    duration = null != duration ? duration : PAGE_LOAD_TIMEOUT;
    driver.manage().timeouts().pageLoadTimeout(duration);
  }

  public void setScriptWaitTimeOut(Duration duration) {
    duration = null != duration ? duration : SCRIPT_WAIT_TIMEOUT;
    driver.manage().timeouts().setScriptTimeout(duration);
  }

  public void closeDriver() {
    driver.close();
  }

  public By getElementWithLocator(String locatorValue, String locatorType) {
    switch (locatorType) {
      case ID:
        return By.id(locatorValue);
      case NAME:
        return By.name(locatorValue);
      case TAGNAME:
        return By.tagName(locatorValue);
      case LINKTEXT:
        return By.linkText(locatorValue);
      case PARTIALLINKTEXT:
        return By.partialLinkText(locatorValue);
      case XPATH:
        return By.xpath(locatorValue);
      case CSS:
        return By.cssSelector(locatorValue);
      case CLASSNAME:
        return By.className(locatorValue);
      default:
        return null;
    }
  }

  public WebElement findByElement(String by, String action) {

    WebElement webElement = driver.findElement(getElementWithLocator(by, action));
    if (Objects.nonNull(webElement)) {
      return webElement;
    } else {
      throw new NotFoundException("Given Element is not there for locator " + by);
    }
  }

  public List<WebElement> findByElements(String by, String action) {

    List<WebElement> webElement = driver.findElements(getElementWithLocator(by, action));
    if (Objects.nonNull(webElement)) {
      return webElement;
    } else {
      throw new NotFoundException("Given Element is not there for locator " + by);
    }
  }

}
