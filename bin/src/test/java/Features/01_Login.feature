Feature: Login

  Scenario Outline: Test login functionality with invalid credentials
    Given user is on the Square Trade Dealers Portal login page
    When Login with invalid "<email>" and "<password>"
    Then error validation message is shown
    Examples:
      | email                   | password             |
    #  |                             |                      |
      | amnkhan+qa2@squaretrade.com | incorrectpassword123 |
#      |       incorrectemail        |       testauto@123   |
#
#
  Scenario Outline:  Test login functionality with valid credentials
    Given user is on the Square Trade Dealers Portal login page
    When Login with valid "<email>" and "<password>"
    Then Verify the Login is successful
#    @all
#    Examples:
#      | username                    | password      |
#      | amnkhan+qa1@squaretrade.com | clicktest@123 |
    Examples:
      | email                  | password        |
      | automation+test2@test.com | SquareTrade@123 |

  Scenario Outline: Test login functionality using OTP
    Given user is on the Square Trade Dealers Portal login page
    When Login with "<email>" and "<password>"
    Then Verify the Login is successful
    Examples:
      | email                    | password   |
      |sahanif+test@squaretrade.com |Test12345#%.|