Feature:

  Background:

    Given User is in home page

  Scenario Outline: User should be able to go to footer links

    When user opens the footer link page "<Footer Link>"
    Then the page should be open with text "<Footer Link>"

    Examples:

    |Footer Link|
    |Search     |
    |News       |