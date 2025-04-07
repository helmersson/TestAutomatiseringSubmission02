Feature: Account creation for Basketball England

  Background:
    Given Navigate to the "New Supporter Account" Page
    And User enters their date of birth as "<dob>"

  Scenario Outline: Successful account creation
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<password>"
    And User selects roles as "<role>"
    And User accepts communication
    And Check that User accepted communication
    And User accepts the ToS
    And Check that User accepted ToS
    And User accepts the Code of Conduct
    And Check that User accepted Code of Conduct
    And User clicks on the confirm and join button
    Then A successful account is created

    Examples:
      | dob | first_name | last_name | email | password | role   |
      | dob | first_name | last_name | email | password | Player |

  Scenario Outline: Account creation without last name
      And User enters first name as "<first_name>"
      And User enters last name as "<last_name>"
      And User enters email address as "<email>"
      And User confirms email as "<email>"
      And User enters password as "<password>"
      And User confirms password as "<password>"
      And User selects roles as "<role>"
      And User accepts communication
      And User accepts the ToS
      And User accepts the Code of Conduct
      And User clicks on the confirm and join button
      Then A error message pops up indicating what the user did wrong

      Examples:
        | dob | first_name | last_name | email | password | role   |
        | dob | first_name |           | email | password | Player |

  Scenario Outline: Account creation with missmatched passwords
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<notTheSamePassword>"
    And User selects roles as "<role>"
    And User accepts communication
    And User accepts the ToS
    And User accepts the Code of Conduct
    And User clicks on the confirm and join button
    Then A error message pops up indicating what the user did wrong

    Examples:
      | dob | first_name | last_name | email | password | notTheSamePassword    | role   |
      | dob | first_name | last_name | email | password | notTheSamePassword123 | Player |

  Scenario Outline: account creation without accepting ToS
    And User enters first name as "<first_name>"
    And User enters last name as "<last_name>"
    And User enters email address as "<email>"
    And User confirms email as "<email>"
    And User enters password as "<password>"
    And User confirms password as "<password>"
    And User selects roles as "<role>"
    And User accepts communication
    And User does not accept the ToS
    And User accepts the Code of Conduct
    And User clicks on the confirm and join button
    Then A error message pops up indicating what the user did wrong

    Examples:
      | dob | first_name | last_name | email | password | role   |
      | dob | first_name | last_name | email | password | Player |