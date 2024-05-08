Feature: Actions Practice

  @Actions
  Scenario: Amazon actions practice
  Given I want to launch amazonUrl page
	When I move to the actionsPageAccount element
	And I build and perform actions
	When I move to the actionsPageSearchBox element
	And press shift key and type hello
	And double click and select it
	And I build and perform actions