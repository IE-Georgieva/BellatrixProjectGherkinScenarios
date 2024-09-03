Feature: Bellatrix Gherkin Project

  Scenario: Verify that "Add to cart" button is working as expected
    Given Bellatrix homepage is loaded successfully
    When The user clicks on "Falcon 9" product`s button
    And The user clicks on "Cart" from navigation menu
    Then The Product is added successfully to cart

  Scenario: Verify that "Read more" button is working as expected
    Given Bellatrix homepage is loaded successfully
    When The user clicks on "Proton-M" product`s button
    Then Button is working as expected

  Scenario: Verify that user can makes successfully order
    Given Bellatrix homepage is loaded successfully
    When The user clicks on "Falcon 9" product`s button
    And The user clicks on "Cart" from navigation menu
    And The user clicks on Checkout button
    And The user populates <field> with <value>
      | firstName     | lastName     | address           | town  | zip  | phoneNumber | emailAddress     |
      | TestFirstName | TestLastName | Mladost 1, 5451 A | Sofia | 1000 | 02365154210 | testEmail@abv.bg |
    And The user clicks on Place order button
    Then Order is received successfully

  Scenario: Verify that user can delete Product from cart
    Given Bellatrix homepage is loaded successfully
    When The user clicks on "Falcon 9" product`s button
    And The user clicks on "Cart" from navigation menu
    And The user clicks on X button
    Then The product should be successfully deleted

  Scenario: Verify that sorting is working correctly
    Given Bellatrix homepage is loaded successfully
    When The user selects Sort by price:high to low from sorting menu
    Then Products should be sorted correctly

  Scenario: Verify that "View cart button" is working correctly
    Given Bellatrix homepage is loaded successfully
    When The user clicks on "Falcon 9" product`s button
    And The user clicks on View cart button
    Then Cart menu should be loaded successfully