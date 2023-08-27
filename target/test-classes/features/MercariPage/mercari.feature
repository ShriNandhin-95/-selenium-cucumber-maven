@Mercari_App
Feature: Search conditions are set correctly

  Scenario: TC_01 Verify the Search conditions are set correctly in Mercari app
    Given browser window is open
    And user is on Mercari app top page
    When user selects the categories as specified for Books, Music & Games
    Then verify the search conditions on the left sidebar are set correctly
    And close the browser

