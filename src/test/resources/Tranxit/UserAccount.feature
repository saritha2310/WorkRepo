
Feature: User Account

    Scenario: User should able to land home page

      When he go to home page
      Then he should see the welcome message

    @Login
    Scenario Outline: User should be able to login successfully with valid credentials

      Given User opened home page
      And entered login page
      When he enters username as "<Username>" and password as "<Password>"
#      And try to login
      Then he should successfully login
      And he should logout

      Examples:

      | Username      | Password |
      |temp1@temp1.com| 7654321  |

#      |demo5@demo5.com| 7654321  |
#      |demo6@demo6.com| 7654321  |

      Scenario Outline: User should not be able to login sucessfully with invalid credentials

        Given User is in home page
        And is in login page
        When he enters username as "<Username1>" and password as "<Password1>"
        And try to login
        Then he should not be successfully login

        Examples:
        | Username1 | Password1 |
        |demo2      | 1234467   |
        |           |           |
        | %$^#      | *&!       |





