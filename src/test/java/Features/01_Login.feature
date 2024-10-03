Feature: Login

  Scenario Outline: Test login functionality with valid credentials
    Given User is on respond.io login page
    When Login with valid "<email>" and "<password>"
    Then Verify the Login is successful

    Examples: 
      | email                    | password  |
      | saimahanif1938@gmail.com | Click123# |
#
  #Scenario Outline: Test login functionality with invalid credentials
    #Given User is on respond.io login page
    #When Login with valid "<email>" and "<password>"
    #And Error validation message is shown
    #Then User must not logged in
#
    #Examples: 
      #| email                    | password  |
      #| saimahanif@gmail.com | Click123. |
