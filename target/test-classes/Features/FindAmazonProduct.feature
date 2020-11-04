Feature: Amazon Product Search
  Feature to test product search functionality on Amazon

  Scenario: Search for a product on Amazon
    Given user navigates to Amazon homepage to URL "http://www.amazon.com/"
    And enters "Nikon" on search text box and presses search button
    When user sorts results in descending order of price
    And selects second product from the result
    Then user should see text "Nikon D3X" on the product topic
