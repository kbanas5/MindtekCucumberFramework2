@regression @ui
  Feature: RedShelf application search functionality

    @RTB-GR1
    Scenario: validating search message
      Given user navigates to "RedShelfApp" application
      When user searches " java data structure " with space in the beginning and at the end
      Then user validates search message "Search results for java data structure ."

    @RTB-GR1
    Scenario: validating search result for particular author
      Given user navigates to "RedShelfApp" application
      When user searches "Seth Godin" author
      Then user validates all books having author "Seth Godin"

    @RTB-GR2
    Scenario: validating add to cart functionality
      Given user navigates to "RedShelfApp" application
      When user searches "Purple Cow" book
      And user chooses first "Purple Cow" book in search results and ads it to the cart
      Then user validates the book "Purple Cow" is in the cart

    @RTB-GR2
    Scenario: validating number or search results on one page
      Given user navigates to "RedShelfApp" application
      When user searches for "Java data structure" book
      Then user validates first result page having no more than 25 books.