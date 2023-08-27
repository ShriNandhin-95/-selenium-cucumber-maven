$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/MercariPage/mercari.feature");
formatter.feature({
  "name": "Search conditions are set correctly",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Mercari_App"
    }
  ]
});
formatter.scenario({
  "name": "TC_01 Verify the Search conditions are set correctly in Mercari app",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Mercari_App"
    }
  ]
});
formatter.step({
  "name": "browser window is open",
  "keyword": "Given "
});
formatter.match({
  "location": "MercariPageSteps.browser_window_is_open()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on Mercari app top page",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.user_is_on_Mercari_app_top_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects the categories as specified for Books, Music \u0026 Games",
  "keyword": "When "
});
formatter.match({
  "location": "MercariPageSteps.user_selects_the_category_as_specified()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the search conditions on the left sidebar are set correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "MercariPageSteps.verify_the_search_conditionns_on_the_left_sidebar_are_set_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/MercariPage/mercari_navigation.feature");
formatter.feature({
  "name": "Search conditions are set correctly",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Mercari_App"
    }
  ]
});
formatter.scenario({
  "name": "TC_02 Search conditions are set correctly from the latest browsing history.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Mercari_App"
    }
  ]
});
formatter.step({
  "name": "browser window is open",
  "keyword": "Given "
});
formatter.match({
  "location": "MercariPageSteps.browser_window_is_open()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on Mercari app top page",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.user_is_on_Mercari_app_top_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects the categories as specified for baby kids",
  "keyword": "When "
});
formatter.match({
  "location": "MercariPageSteps.user_selects_the_category_as_specified_for_baby_kids()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects the categories as specified for Books, Music \u0026 Games",
  "keyword": "When "
});
formatter.match({
  "location": "MercariPageSteps.user_selects_the_category_as_specified()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the 2 browsing history is showing correctly and click on the latest",
  "keyword": "Then "
});
formatter.match({
  "location": "MercariPageSteps.verify_the_browsing_history_is_showing_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the search conditions on the left sidebar are set correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "MercariPageSteps.verify_the_search_conditionns_on_the_left_sidebar_are_set_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sends javascript in the search bar and search with the keyword",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.user_sends_javascript_in_the_search_bar_and_search_with_the_keyword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on Mercari app top page",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.user_is_on_Mercari_app_top_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the 3 browsing history is showing correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "MercariPageSteps.verify_the_3_browsing_history_is_showing_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "MercariPageSteps.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});