#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Teams creation Module in Administration
 This feature aims to test and create the Teams functionality within the application

  
Scenario: User Login
 Given I visit the User Login using sheetname "Credentials" and rownumber 0
 And I enter the credentials and click a login button
 
   
 Scenario: Verify by clicking on Teams under Administration
 Then Clicking on Teams module under Administration
 Then Clicking on Add Team button to add the Team
 
     
 Scenario: verify by entering valid Team name
 Then Entering Valid Team name using sheetname "Teams Module" and rownumber 0
 
  
 Scenario: verify by entering valid Team code
  Then Entering Valid Team code using sheetname "Teams Module" and rownumber 0
 Then Click On Create button
 
 
 
 
 
 
 
