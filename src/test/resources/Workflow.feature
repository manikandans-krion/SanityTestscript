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

	Feature: Creating workflow separately
 	This feature aims to test and create the workflow and other functionality in it under Design module within the application.
 
 
    @Run
		Scenario: User Login for Design Projects for wf
  	Given I visit the User Login for Design Projects for wf using sheetname "Credentials" and rownumber 0
  	And I enter the credentials in login and click a login button for wf

	  @Run
    Scenario: Verify by clicking on Project module Under Design section for wf
    Then Clicking on Project module under Design section for wf
	
 		@Run
  	Scenario: Verify by filtering the required project and clicking on it for wf
  	Then filtering the required project and clickin on it for wf using sheetname "Add Project" and rownumber 0
  		
  	@Run
  	Scenario: Verify by clicking the settings module in newly Created Project under Design module for wf
  	Then Clciking on Setting module in newly Created Project under Design module for wf
 		
 		
 		
 			
 		@Run
 		Scenario: Creating workflow based on the type selected in the select category of the project
 		Then Creating workflow based on the type selected in the select category of the project using sheetname "Workflow" and rownumber 0
 		
 