Feature: Account creation for Basketball England

  Background:
    Given Navigate to the "New Supporter Account" Page
    And Verify that we are on the "New Supporter Account" Page


  Scenario Outline: Successful account creation
    And User enters their date of birth as "<dob>"
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<password>"
    And User selects roles as "<role>"
    And User accepts the ToS
    And User accepts the Code of Conduct
    ##  And User clicks on the confirm and join button
    Then A successful account is created

    Examples:
      | dob        | first_name | last_name  | email                         | password | role   |
      | 06/09/1995 | Wilhelm    | Helmersson | wilhelmhelmersson@example.com | Wille123 | Player |
      | 06/09/1994 | Vilhelm    | Andersson  | vilhelmandersson@example.com  | Ville123 | Player |

  Scenario Outline: Account creation without last name
    And User enters their date of birth as "<dob>"
    And User enters first name as "<first_name>"
      And User enters last name as "<last_name>"
      And User enters email address as "<email>"
      And User confirms email as "<email>"
      And User enters password as "<password>"
      And User confirms password as "<password>"
      And User selects roles as "<role>"
      And User accepts the ToS
      And User accepts the Code of Conduct
      And User clicks on the confirm and join button
      And Check that last name error message is visible
      Then A error message pops up indicating what the user did wrong

      Examples:
        | dob        | first_name | last_name | email                         | password | role   |
        | 06/09/1995 | Wilhelm    |           | wilhelmhelmersson@example.com | Wille123 | Player |
        | 06/09/1994 | Vilhelm    |           | vilhelmandersson@example.com  | Ville123 | Player |

  Scenario Outline: Account creation with missmatched passwords
    And User enters their date of birth as "<dob>"
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<notTheSamePassword>"
    And User verifies that the passwords are correct
    And User selects roles as "<role>"
    And User accepts the ToS
    And User accepts the Code of Conduct
    And User clicks on the confirm and join button
    And Checks that password error message is visible
    Then A error message pops up indicating what the user did wrong

    Examples:
      | dob        | first_name | last_name  | email                         | password | notTheSamePassword | role   |
      | 06/09/1995 | Wilhelm    | Helmersson | wilhelmhelmersson@example.com | Wille123 | wille123           | Player |
      | 06/09/1994 | Vilhelm    | Andersson  | vilhelmandersson@example.com  | Ville123 | ville123           | Player |

  Scenario Outline: account creation without accepting ToS
    And User enters their date of birth as "<dob>"
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<password>"
    And User selects roles as "<role>"
    And User accepts the Code of Conduct
    And User clicks on the confirm and join button
    And Check that User accepted ToS
    Then A error message pops up indicating what the user did wrong

    Examples:
      | dob        | first_name | last_name  | email                         | password | role   |
      | 06/09/1995 | Wilhelm    | Helmersson | wilhelmhelmersson@example.com | Wille123 | Player |
      | 06/09/1994 | Vilhelm    | Andersson  | vilhelmandersson@example.com  | Ville123 | Player |