@Mercari_App
Feature: Search conditions are set correctly

  Scenario: TC_02 Search conditions are set correctly from the latest browsing history.

    Given browser window is open
    And user is on Mercari app top page
    When user selects the categories as specified for baby kids
    When user selects the categories as specified for Books, Music & Games
    Then verify the 2 browsing history is showing correctly and click on the latest
    Then verify the search conditions on the left sidebar are set correctly
    And user sends javascript in the search bar and search with the keyword
    And user is on Mercari app top page
    Then verify the 3 browsing history is showing correctly
    And close the browser