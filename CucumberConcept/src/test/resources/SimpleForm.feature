Feature: Enter contact information into a form and validate everything is ok

Scenario: Check form is validated when there are no errors 
	Given I am on simple form website
	When Populate contact form
	Then I should see everything is ok
	
Scenario: Check form is invalid when bad data entered
	Given I am on simple form website
	When Populate invalid data in contact form
	Then I should see error