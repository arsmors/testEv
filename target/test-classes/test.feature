Feature: A description

  Scenario Outline: A scenario
    Given website with category "<category>"
    When user open single ad
    And add to favorites
    Then ads with count "<count>" are displayed in memos page

    Examples:
      | category                                 | count |
      | /electronics/phones/mobile-phones/apple/ | (1)   |