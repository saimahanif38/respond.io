Feature: Verify workflow

  Scenario Outline: Verify workflow to create a workflow
    Given User is on respond.io login page
    When Login with valid "<email>" and "<password>"
    Then Verify the Login is successful
    And Perform steps to add workflow

    Examples: 
      | email                    | password  |
      | saimahanif1938@gmail.com | Click123# |
