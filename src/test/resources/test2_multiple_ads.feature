Feature: B description

  Scenario Outline: B scenario
    Given website with category "<category>"
    When user select <ads> ads
    And add to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar

    Examples:
      | category                                 | ads |
      | /electronics/phones/mobile-phones/apple/ | 5   |