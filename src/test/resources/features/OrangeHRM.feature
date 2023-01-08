Feature: Orange HRM features
  @RTB-222


  Scenario Outline: Create new PMI feature
    Given Admin navigates to Orange HRM with userName "Admin" and password "admin123"
    When  Admin  clicks PIM button and creates new user with "<first name>" and "<last name>" and clicks the save button
    And Admin proceeds with additional new user information and clicks the save button
      | DL number      | D123-456-789 |
      | Expiry date    | 2024-05-23   |
      | SSN number     | 123-45-6789  |
      | Nationality    | French       |
      | Marital Status | Married      |
      | Date of Birth  | 1985-12-05   |
      | Gender         | Male         |

    Then   Admin validates new user "<first name>" "<last name>" is added
      | Username         | Pierre.Muller |
      | Password         | 123Mus456$     |
      | Confirm Password | 123Mus456$     |

    Examples:
    |first name|last name|
    |Pierre    |Muller   |

  @RTB-223
  Scenario: user edit functionality
    Given Admin navigates to Orange HRM with userName "Admin" and password "admin123"
    When Admin navigates to PIM module and chooses edit option for user of his choice and edits information
    Then Admin validates the changes with the message "Successfully Updated"

