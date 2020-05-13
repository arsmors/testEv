Feature: A description

  Scenario Outline: A scenario
    Given website with category "<category>"
#    When user select "<ads>" ads
#    And add to memos
#    Then ads with count 1 are displayed in memos page
#    And user deletes all ads from memo page

    Examples:
      | category                                 | ads |
      | /electronics/phones/mobile-phones/apple/ | 1   |