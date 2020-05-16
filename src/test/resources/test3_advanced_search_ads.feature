Feature: C description

  Scenario Outline: C scenario
    When user go to "<section>" section
    And search for "<item>" item
    And user select <ads> ads
    And add to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar

    Examples:
      | section | item | ads |
      | Search  | ford | 5   |