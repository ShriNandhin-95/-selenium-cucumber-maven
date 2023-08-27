package stepdefs;

import ApplicationPages.HomePage;
import com.sample.assesment.WebConnector.webconnector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageSteps extends webconnector {

  private final HomePage mercariPage;
  private String scenDesc;

  public PageSteps() {
    this.mercariPage = new HomePage();
  }

  @And("^user is on Mercari app top page")
  public void user_is_on_Mercari_app_top_page() {
    log.info("Inside Step - user is on Mercari search page");
    this.mercariPage.goToHomePage();
  }

  @When("^user selects the categories as specified for Books, Music & Games$")
  public void user_selects_the_category_as_specified() {
    this.mercariPage.selectSpecifiedUserCategory();
  }

  @Then("^verify the search conditions on the left sidebar are set correctly")
  public void verify_the_search_conditionns_on_the_left_sidebar_are_set_correctly() {
    this.mercariPage.searchSelectConditionValidation();
  }

  @When("^user selects the categories as specified for baby kids$")
  public void user_selects_the_category_as_specified_for_baby_kids() throws Throwable {
    this.mercariPage.selectSpecifiedUserCategoryForBabyKids();

  }

  @Then("^verify the 2 browsing history is showing correctly and click on the latest")
  public void verify_the_browsing_history_is_showing_correctly() throws Throwable {

    this.mercariPage.verifyBrowsingHistory();

  }

  @And("^user sends javascript in the search bar and search with the keyword")
  public void user_sends_javascript_in_the_search_bar_and_search_with_the_keyword()
      throws Throwable {
    this.mercariPage.sendUserActionAsJavaScript();

  }

  @Then("^verify the 3 browsing history is showing correctly")
  public void verify_the_3_browsing_history_is_showing_correctly() throws Throwable {

    this.mercariPage.verify_the_3_browsing_history_is_showing_correctly();

  }

  @Given("^browser window is open")
  public void browser_window_is_open() {
    mercariPage.open();

  }

  @Then("^close the browser")
  public void close_the_browser() {
    this.mercariPage.close();

  }
}
