Feature:

  Background:

    Given User is in home page


  Scenario Outline: User should be able to go to a product category
      When user opens the product category page "<category>"
      Then the page should be open with text "<category>"

      Examples:
        |category    |
        |Computers   |
        |Electronics |
        |Apparel     |


    Scenario Outline: User should be able to go to particular product type in a category
      Given user opens the product category page "<category>"
      When user opens a product type "<ptype>"
      Then the page should be open with text "<ptype>"
      And user opens actual product "<product>"
      Then the page should be open with text "<text>"

      Examples:
        | category   | ptype        | product                             | text   |
        |Computers   | Desktops     | /build-your-own-computer             | Build your own computer |
        |Computers   | Desktops     | Lenovo IdeaCentre 600 All-in-One PC | Lenovo IdeaCentre 600 All-in-One PC |
        |Computers   | Notebooks    | Apple MacBook Pro 13-inch           | Apple MacBook Pro 13-inch           |
        |Electronics | Cell phones  | body > div.master-wrapper-page > div.master-wrapper-content > div.master-column-wrapper > div.center-2 > div > div.page-body > div.product-grid > div > div:nth-child(2) > div > div.details > h2 > a                 | HTC One Mini Blue                 |


  @reg
  Scenario Outline: User should be able to go to particular product

    Given user opens the product category page
    When user opens a product
    Then the page should be open with text "<product>"
    And the image should display
    And the price should display
    And the review link should display
    And the product should be able to add to cart
    //Then the success message should display


    Examples:
      |product|
      |Pride and Prejudice|




