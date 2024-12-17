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

Feature: Role creation Module in Administration
  This feature aims to test and create the Role functionality within the application.




  
Scenario: User Login
 Given I visit the User Login using sheetname "Credentials" and rownumber 0
 And I enter the credentials and click a login button
 
     
 Scenario: Verify by clicking on Role under Administration
 Then Clicking on Role module under Administration
 Then Clicking on Add Role button to add the role
 
      
 Scenario: verify by entering valid Role name
 Then Entering Valid Role name using sheetname "Role Module" and rownumber 0
 
 
      
  Scenario: verify by selecting All Check box to all the permission to the Role user and creating it
  Then Clicking on Select all check box to give all the persmission to the roles user
  Then Click On Create button
  
  #TEAMS#
  
     
 Scenario: Verify by clicking on Teams under Administration
 Then Clicking on Teams module under Administration
 Then Clicking on Add Team button to add the Team
 
     
 Scenario: verify by entering valid Team name
 Then Entering Valid Team name using sheetname "Teams Module" and rownumber 0
 
  
 Scenario: verify by entering valid Team code
  Then Entering Valid Team code using sheetname "Teams Module" and rownumber 0
 Then Click On Create button on Teams
  
  
   #FormTemplate#
  
   
   Scenario: Verify by clicking on Form Template under Administration
 Then Clicking on Form Template module under Administration
 Then Clicking on Add Form  Template button to add the Form
 
   
 Scenario: verify by entering valid Form name
 Then Entering Valid Form name using sheetname "Form Template" and rownumber 0
  
    
  Scenario: Verify by uploading PDF file in the field
  Then Uploading PDF file using sheetname using sheetname "Form Template" and rownumber 0
  Then Click on Create button to create Form Template
  
  
  
  
  
  
  
  
  
  
