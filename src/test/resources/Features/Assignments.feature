Feature: First Cucumber Feature

  @Assignments
  Scenario: Assignment Two
    Given I want to launch angularPractice page
    And I enter username
    And I enter email
    And I enter password
    When I check on the checkbox
    And select gender as male
    And mark my employment status as Student
    Then I Enter my date of birth as 12-Mar-1999
    And I click on submit button

  @Assignments
  Scenario: Assignment Three
    Given I want to launch loginPracticeURL page
    And I want to enter rahulshettyacademy in loginPageUserName
    And I want to enter learning in loginPagePassWord
    When I click on loginPageUser radioButton
    And accept the popUpMsg
    When I select loginPageSelector using visibleText Consultant
    Then I verify loginPageSelector value is Consultant
    And I click on loginPageTerms checkbox
    And I click on loginPageSignIn button
