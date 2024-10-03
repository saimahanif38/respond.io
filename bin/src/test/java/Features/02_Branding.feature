#Feature: Verify branding of the users
#
#  Scenario Outline: Verify the branding of users
#    Given user with "<username>" and "<password>" is logged in
#    When user is on dashboard
#    Then branding "<color>" should be shown for user with "<username>"
##    @qa
##    Examples:
##      | username                    | password      | color |
##      | amnkhan+qa1@squaretrade.com | clicktest@123 | blue  |
##      | amnkhan+qa2@squaretrade.com | clicktest@123 | green |
#    @all
#    Examples:
#      | username                    | password        | color |
#      | automation+test1@test.com   | SquareTrade@123 | blue  |
#      | automation+test2@test.com   | SquareTrade@123 | green |