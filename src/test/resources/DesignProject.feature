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

##Comment the Tag which you dont want to run by using "#" 

Feature: Creating Projects and other functionalities realted to it
   This feature aims to test and create & Edit the Projects and other functionality in it under Design module within the application.

  #Login Page -> Login
  
  @Run
  Scenario: User Login for Design Projects
    Given I visit the User Login for Design Projects using sheetname "Credentials" and rownumber 0
    And I enter the credentials in login and click a login button

  #Creating a New Project
  
  @Run
  Scenario: Verify by clicking on Project module Under Design section
    Then Clicking on Project module under Design section
		Then Click on ADD Project button to create new project
		
  @Run
  Scenario: Verify by Choosing whether to create ISO project or Non-ISO project
    Then Choosing whether to create ISO project or Non-ISO project using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by selecting the project template
    Then Clicking on Project template field and selecting the template using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the valid project code
    Then Entering valid project code using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the valid project name
    Then Entering valid project name using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the project description
    Then Entering valid project description using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the project Start Date
    Then Entering Start Date of the project using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project Design type from drop-down
    Then Enter and select the project design type from drop-down using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project category type from drop-down
    Then Enter and select the project category type from drop-down using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project owner type from drop-down
    Then Enter and select the project owner type from drop-down using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project status type from drop-down
    Then Enter and select the project status type from drop-down using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering address in address line one field
    Then Entering address in address line one field using sheetname "Add Project" and rownumber 0

   @Run
  Scenario: Verify by Entering address in address line two field
    Then Entering address in address line two field using sheetname "Add Project" and rownumber 0

	@Run
  Scenario: Verify by Entering City name in the field
    Then Entering City name in the field using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering State name in the field
    Then Entering State name in the field using sheetname "Add Project" and rownumber 0

 	@Run
  Scenario: Verify by Entering valid Pincode in the field
    Then Entering valid Pincode in the field using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by Entering Country name in the field
    Then Entering Country name in the field using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by clicking on Create button to create new project
    Then Click on Create button to create new project

  #Filtering the required project by using the search box field and creating a Assign role for the users#
  @Run
  Scenario: Verify by filtering the required project and clicking on it
    Then filtering the required project and clickin on it using sheetname "Add Project" and rownumber 0

  @Run
  Scenario: Verify by clicking the settings module in newly Created Project under Design module
    Then Clciking on Setting module in newly Created Project under Design module

  #Assign Role#
  @Run
  Scenario: Verify by clicking on Assign role sub-module under settings in newly Created Project under Design module
    Then Clciking on Assign role sub-module under settings in newly Created Project under Design module

  @Run
  Scenario: Verify by clicking on Assign Role button to assigning the role to the user
    Then Clicking on Assign Role button to assigning the role to the user

  @Run
  Scenario: Veriffy by Clicking on Select role drop-down to select the required role from the list
    Then Clicking on Select role drop-down to select the required role from the list using sheetname "Assign Role" and rownumber 0

  @Run
  Scenario: Veriffy by Clicking on Add user drop-down to select the required number of users from the list
    Then Clicking on Add user drop-down to select the required number of users from the list sheetname "Assign Role" and rownumber 0

  @Run
  Scenario: Veirfy by clicking on Assign button to assign the role for the desire number of users
    Then Clicking on Assign button to assing the role for the desire number of users

  #Assign Role For Group#
  
  @Run
  Scenario: verify by clicking on Assign Role for Group tab
    Then Clicking on Assign Role for Group tab

  @Run
  Scenario: Verify by clicking on Assign Role Group button to create a group
    Then Clickingon Assign Role Group button to create a group

  @Run
  Scenario: Veriffy by Clicking on Select role drop-down to select the required role from the list for Group
    Then Clicking on Select role drop-down to select the required role from the list for Group using sheetname "Assign Role" and rownumber 0

  @Run
  Scenario: Veriffy by Clicking on Add group drop-down to select the required number of users from the list
    Then Clicking on Add group drop-down to select the required number of users from the list sheetname "Assign Role" and rownumber 0

  @Run
  Scenario: Veirfy by clicking on Assign button to assign the role for the desire number of users in group
    Then Clicking on Assign button to assing the role for the desire number of users users in group

  #WorkFlow Creation#
  
  @Run
  Scenario: Creating workflow based on the type selected in the select category of the project
    Then Creating workflow based on the type selected in the select category of the project using sheetname "Workflow" and rownumber 0

  #Documents ----> Document Module ----> Kamal
  
  @Run
  Scenario: Verify the uploading documents in document module
    Then Click on File upload button in document module
    Then upload the document using sheetname "Document"

  #Actions -> Review Page Creation
  
  @Run
  Scenario: Verify by clicking on Action module from sidebar
    Then Clicking on Action module from sidebar

  #Review Module
  
  @Run
  Scenario: Verify by clicking on Review sub-module from sidebar
    Then Clicking on Review sub-module from sidebar
    Then Clicking on ADD button to create Add review

  @Run
  Scenario: Verify by Selecting Parent Review name from the drop-down
    Then Selecting Parent Review name from the drop-down using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on Review Code field
    Then Entering  valid code on Review Code field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Review Name field
    Then Entering valid name on Review Name field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field
    Then Entering Description on the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid start date on the field
    Then Entering valid start date on the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid End date on the field
    Then Entering valid End date on the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting workflow on the field
    Then Selecting workflow on the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting priority from the drop-down
    Then Selecting priority from the drop-down using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimate cost in the field
    Then Entering valid Estimate cost in the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual cost in the field
    Then Entering valid Actual cost in the field using sheetname "Add Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting checklist from the drop-down
    Then Selecting checklist from the drop-down using sheetname "Add Review" and rownumber 0
    Then Clicking on Create button to create a Review for the project

  #Actions -> Issue Page Creation
 
  @Run
  Scenario: Verify by clicking on Issues sub-module from sidebar
    Then Clicking on Issues sub-module from sidebar
    Then Clicking on ADD button to create Add Issues

  @Run
  Scenario: Verify by Entering valid code on Issue Code field
    Then Entering valid code on Issue Code field using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Name field
    Then Entering valid name on Name field using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field Add Issue
    Then Entering Description on the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid start date on the field Add Issue
    Then Entering valid start date on the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Due date on the field Add Issue
    Then Entering valid Due date on the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Type from the drop-down Add Issue
    Then Selecting Type from the drop-down using sheetname "Add Issue" and rownumber 0

   @Run
  Scenario: Verify by Selecting Placement from the drop-down Add Issue
    Then Selecting Placement from the drop-down using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Root cause from the drop-down Add Issue
    Then Selecting Root cause from the drop-down using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Workflow from the drop-down Add Issue
    Then Selecting Workflow from the drop-down in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering Location in the field Add Issue
    Then Entering Location in the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimate cost in the field Add Issue
    Then Entering valid Estimate cost in the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual cost in the field Add Issue
    Then Entering valid Actual cost in the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Uploading an image in Add Issue
    Then Uploading an Image in the field in add issue using sheetname "Add Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down in Add Issue
    Then Selecting Attach files from the drop-down in add issue using sheetname "Add Issue" and rownumber 0
    Then Clicking on Create button to create a Issue in the project

  #Actions -> RFI Page Creation  --------> Kamal
  
  @Run
  Scenario: Verify the user is creating the RFI
    And Navigate to RFI in the Action Module
    Then Click the Add button

  @Run
  Scenario: Verify entering valid RFI details
    And Click the toggle button using the sheetname "RFI" and rownumber 0

   @Run
  Scenario: Verify entering valid RFI code
    When Clear the default code in the RFIcode field
    Then Enter the RFI code using the sheetname "RFI" and rownumber 0

   @Run
  Scenario: Verify entering valid RFI name field
    And Enter the RFI name using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI Question field
    And Enter the RFI Question using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Suggested answer field
    And Enter the Answer using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Due Date field
    Then Enter the Due Date using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Location field
    Then Enter the Location using the sheetname "RFI" and rownumber 0

 	@Run
  Scenario: Verify selecting  valid Type field from the dropdown
    Then Select Type dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Discipline field from the dropdown
    Then Select Discipline dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Category field from the dropdown
    Then Select Category dropdown using the sheetname "RFI" and rownumber 0

 	@Run
  Scenario: Verify selecting valid Workflow field from the dropdown
    Then Select Workflow dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority field from the dropdown
    Then Select Priority dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify Uploading image in the Upload photos/images field
    Then Upload image from the image path using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Attach the file name using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the create button
    Then RFI should be created

  #Actions -> RFA Page Creation
  
  @Run
  Scenario: Verify by clicking on RFA sub-module from sidebar
    Then Clicking on RFA sub-module from sidebar
    Then Clicking on ADD button to create Add RFA

  @Run
  Scenario: Verify by Entering valid code on RFA Code field
    Then Entering valid code on RFA Code field using sheetname "Add RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on RFA Name field
    Then Entering valid name on RFA Name field using sheetname "Add RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field Add RFA
    Then Entering Description on the field in add RFA using sheetname "Add RFA" and rownumber 0

   @Run
  Scenario: Verify by Entering valid start date on the field Add RFA
    Then Entering valid start date on the field in add RFA using sheetname "Add RFA" and rownumber 0

   @Run
  Scenario: Verify by Entering valid End date on the field Add RFA
    Then Entering valid End date on the field in add RFA using sheetname "Add RFA" and rownumber 0

  @Run
  Scenario: Verify by Selecting Workflow from the drop-down Add RFA
    Then Selecting Workflow from the drop-down in add RFA using sheetname "Add RFA" and rownumber 0

   @Run
  Scenario: Verify by Selecting priority from the drop-down Add RFA
    Then Selecting priority from the drop-down in add RFA using sheetname "Add RFA" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down under checklist and attaching the files
    Then Selecting Attach files from the drop-down and attaching the files using sheetname "Add RFA" and rownumber 0
    Then Clicking on Create button to create a RFA for the project

  # Attachments - >  FORM Module -----> Kamal
  
  @Run
  Scenario: Verify by clicking on Attachments module from sidebar
    Then Clicking on Attachments module from sidebar

   @Run
  Scenario: Verify the user is creating the Daily Report
    And Route to Form in the Attachments Module
    And Select the report in the FORMS using the sheetname "Form" and rownumber 0
    Then Click the Add button on the screen

  @Run
  Scenario: Verify entering from date
    Then Enter the from date using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify entering due date
    Then Enter the due date using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify entering location
    Then Enter the locationname using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify selecting workflow
    Then select workflowname using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify entering description
    Then Enter description using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify user click the Add work button
    Then Click Add Work button

  @Run
  Scenario: Verify entering add work details
    Then Enter work details using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in work pop up
    Then Click Save button to save work details

  @Run
  Scenario: Verify user click the Add Material button
    Then Click Add Material button

  @Run
  Scenario: Verify entering add material details
    Then Enter material details using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in material popup
    Then Click Save button to save material details

  @Run
  Scenario: Verify user click the Add Equipment button
    Then Click Add Equipment button

  @Run
  Scenario: Verify entering add Equipment details
    Then Enter Equipment details using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in Equipment popup
    Then Click Save button to save Equipment details

  @Run
  Scenario: Verify user entering Notes
    Then Enter Notes using the sheetname "Form" and rownumber 0

  @Run
  Scenario: Verify user created form
    Then click the create button

  #Attachments - > Check List Module Page Creation
  
  @Run
  Scenario: Verify by clicking on check List sub-module under Attachments
    Then Clicking on check List sub-module
    Then Clicking on Add button to create check List for the project

   @Run
  Scenario: Verify by Entering valid checklist code on checklist Code field in check list
    Then Entering valid code on checklist Code field using sheetname "Add checklist" and rownumber 0

  @Run
  Scenario: Verify by Entering valid checklist Name on checklist Name field in check list
    Then Entering valid Name on checklist Name field using sheetname "Add checklist" and rownumber 0

  @Run
  Scenario: Verify by Entering values under Checklist Item Fields
    Then Entering values under Checklist Item Fields using sheetname "Add checklist items" and rownumber 0
    Then Click on Create Button to create checklist

  #Attachments - > BOM/BOQ Creating for the project
  
  @Run
  Scenario: Verify by clicking on BOM/BOQ sub-module under Attachments
    Then Clicking on BOM/BOQ sub-module
    Then Clicking on Add button to create BOM/BOQ for the project

  @Run
  Scenario: Verify by Selecting Parent BOM/BOQ name from the drop-down in BOM/BOQ
    Then Selecting Parent BOM/BOQ name from the drop-down in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on BOM/BOQ Code field in BOM/BOQ
    Then Entering valid code on BOM/BOQ Code field using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Name field in BOM/BOQ
    Then Entering valid name on Name field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Selecting workflow on the field in BOM/BOQ
    Then Selecting workflow on the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Selecting priority from the drop-down in BOM/BOQ
    Then Selecting priority from the drop-down in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid unit field from the drop-down in BOM/BOQ
    Then Entering valid unit field from the drop-down in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimated Quantity in the field in BOM/BOQ
    Then Entering valid Estimated Quantity in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimated Price per unit in the field in BOM/BOQ
    Then Entering valid Estimated Price per unit in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Estimated Total value in the field in BOM/BOQ
    Then Verifying Estimated Total value in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Ordered Quantity in the field in BOM/BOQ
    Then Entering valid Ordered Quantity in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Quoted Price per unit in the field in BOM/BOQ
    Then Entering valid Quoted Price per unit in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verifying the Quoted Total value in the field in BOM/BOQ
    Then Verifying the Quoted Total value in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual Quantity in the field in BOM/BOQ
    Then Entering valid Actual Quantity in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual Price per unit in the field in BOM/BOQ
    Then Entering valid Actual Price per unit in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verifying the Actual Total value in the field in BOM/BOQ
    Then Verifying the Actual Total value in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Remarks in the field in BOM/BOQ
    Then Entering valid Remarks in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid GUID in the field in BOM/BOQ
    Then Entering valid GUID in the field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by uploading valid QR code file in the Attach QR code field in BOM/BOQ
    Then Uploading valid QR code file in the Attach QR code field in BOM/BOQ using sheetname "Add BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Clicking on Add Properties button and entering values in the field Property name and Property value in BOM/BOQ
    Then Clicking on Add Properties button and entering values in the field Property name and Property value using sheetname "Add BOMBOQ" and rownumber 0
    Then Clicking on Create button to create BOM for the project

  # Share - > Submittals Module -----> Kamal
  
  @Run
  Scenario: Verify by clicking on Share module from sidebar
    Then Clicking on Share module from sidebar

  @Run
  Scenario: Verify the user is creating the Submittals
    And Navigate to Submittals in the Share Module
    Then Click Add button on the screen

  @Run
  Scenario: Verify entering valid Submittals details
    And Click toggle button using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid code
    When Clear the default code in the Submittalcode field
    Then Enter the Submittalcode using the sheetname "Submittals" and rownumber 0

   @Run
  Scenario: Verify entering valid name
    And Enter the submittalname using the sheetname "Submittals" and rownumber 0

   @Run
  Scenario: Verify entering valid Spec Section
    And Select the Spec Section dropdown using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Sub Spec Section
    And Select the Sub Spec Section dropdown using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Description
    Then Enter the Descriptions using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Type
    Then Select the Type dropdown using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow
    Then Select the Workflow for submittal dropdown using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Due Date
    Then Enter Due Date using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority
    Then Select the Priority dropdown using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required Date
    Then Enter Required Date using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required approval Date
    Then Enter Required approval Date using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required on jobsite Date
    Then Enter Required on jobsite Date using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Lead time
    Then Enter Lead time using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Attach file name using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click create button in the screen
    Then Submittals should be created

  # Share - >  Transmittals Module -----> Kamal
  
   @Run
  Scenario: Verify the user is creating the Transmittals
    And Navigate to Transmittals in the Share Module
    Then Click Add button in the screen

   @Run
  Scenario: Verify entering valid Transmittals details
    And Enable or disable the toggle button using the sheetname "Transmittals" and rownumber 0

   @Run
  Scenario: Verify entering valid code
    When Clear the default code in the Transmittalcode field
    Then Enter the Transmittalcode using the sheetname "Transmittals" and rownumber 0

   @Run
  Scenario: Verify entering valid name
    And Enter the Transmittalname using the sheetname "Transmittals" and rownumber 0

   @Run
  Scenario: Verify entering valid Description
    Then Enter the Descriptions of transmittal using the sheetname "Transmittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow
    Then Select the Workflow for transmittal dropdown using the sheetname "Transmittals" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files option
    Then Attach the file by the filename using the sheetname "Transmittals" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the create button in the screen
    Then Transmittals should be created

  # Share - > Meeting Module to create Meetings for the project discussion
  
  @Run
  Scenario: Verify by clicking on Meeting sub-module under share
    Then Clicking on Meeting sub-module
    Then Clicking on Add button to create Meeting for the project

  @Run
  Scenario: Verify by Entering meeting name on Name field in Add Meeting
    Then Entering meeting name on Name field in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Date on date field in Add Meeting
    Then Entering Meeting Date on date field in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Time on date field in Add Meeting
    Then Entering Meeting Time on date field in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Duration hours and minutes field in Add Meeting
    Then Entering Meeting Duration hours and minutes field in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field Add Meeting
    Then Entering Description on the field in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button Add Meeting
    Then Entering Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button in add Meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Selecting the selected Participants from Select Users and Selected Group of Users in Add meeting
    Then Selecting the selected Participants from Select Users and Selected Group of Users in Add meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Uploading an image in Add meeting
    Then Uploading an Image in the field in add meeting using sheetname "Add Meeting" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down under checklist and attaching the files in Add Meeting
    Then Selecting Attach files from the drop-down and attaching the files in Add Meeting using sheetname "Add Meeting" and rownumber 0
    Then Clicking on Create button to create a Meeting for the project

  #======================================================================#
  #=============EDIT_MODULE====================#
  #Design -> Edit Project
  
  @Run
  Scenario: Verify by changing the required fields in Project
    Then Changing the required fields in Project using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Choosing whether to update ISO project or Non-ISO project
    Then Choosing whether to Update ISO project or Non-ISO project using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the valid project code
    Then Update valid project code using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the valid project name
    Then Update valid project name using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the project description
    Then Update valid project description using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering the project Start Date
    Then Update Start Date of the project using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project Design type from drop-down
    Then Update the project design type from drop-down using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project category type from drop-down
    Then Update the project category type from drop-down using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project owner type from drop-down
    Then Update the project owner type from drop-down using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Enter and select the project status type from drop-down
    Then Update the project status type from drop-down using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering address in address line one field
    Then Update address in address line one field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering address in address line two field
    Then Update address in address line two field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering City name in the field
    Then Update City name in the field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering State name in the field
    Then Update State name in the field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Pincode in the field
    Then Update valid Pincode in the field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by Entering Country name in the field
    Then Update Country name in the field using sheetname "Edit Project" and rownumber 0

  @Run
  Scenario: Verify by clicking on Create button to create new project
    Then Click on Update button to update project details

  #=====Actions Module========#
  #Actions -> Edit Review
  
  @Run
  Scenario: Verify by changing the required field in Review module under Action
    Then Changing the required field in Review module under Action using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting Parent Review name from the drop-down
    Then Update Parent Review name from the drop-down using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on Review Code field
    Then Update  valid code on Review Code field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Review Name field
    Then Update valid name on Review Name field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field
    Then Update Description on the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid start date on the field
    Then Update valid start date on the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid End date on the field
    Then Update valid End date on the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting workflow on the field
    Then Update workflow on the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting priority from the drop-down
    Then Update priority from the drop-down using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimate cost in the field
    Then Update valid Estimate cost in the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual cost in the field
    Then Update valid Actual cost in the field using sheetname "Edit Review" and rownumber 0

  @Run
  Scenario: Verify by Selecting checklist from the drop-down
    Then Update checklist from the drop-down using sheetname "Edit Review" and rownumber 0
    Then Clicking on update button to update a Review for the project

  #Actions-> Edit Issue -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the Issue
    Then filtering the required Issue and clicking on it using sheetname "Edit Issue" and rownumber 0
    Then Changing the required fields in Issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on Issue Code field
    Then Update valid code on Issue Code field using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Name field
    Then Update valid name on Name field using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field Issue
    Then Update Description on the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid start date on the field Issue
    Then Update valid start date on the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Due date on the field Issue
    Then Update valid Due date on the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Type from the drop-down Issue
    Then Update Type from the drop-down using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Placement from the drop-down Issue
    Then Update Placement from the drop-down using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Root cause from the drop-down Issue
    Then Update Root cause from the drop-down using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Workflow from the drop-down Issue
    Then Update Workflow from the drop-down in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering Location in the field Issue
    Then Update Location in the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimate cost in the field Issue
    Then Update valid Estimate cost in the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual cost in the field Issue
    Then Update valid Actual cost in the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Uploading an image in Issue
    Then Update by Uploading an Image in the field in add issue using sheetname "Edit Issue" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down in Issue
    Then Update Selecting Attach files from the drop-down in add issue using sheetname "Edit Issue" and rownumber 0
    Then Clicking on Update button to update a Issue in the project

  #Actions-> Edit RFI -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the RFI
    Then filtering the required RFI and clicking on it using sheetname "Edit RFI" and rownumber 0
    Then Changing the required field in RFI using sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI code
    Then Update the RFI code using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI name field
    And Update the RFI name using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI Question field
    And Update the RFI Question using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Suggested answer field
    And Update the Answer using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Due Date field
    Then Update the Due Date using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Location field
    Then Update the Location using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify selecting  valid Type field from the dropdown
    Then Update Type dropdown using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Discipline field from the dropdown
    Then Updaate Discipline dropdown using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Category field from the dropdown
    Then Update Category dropdown using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow field from the dropdown
    Then Update Workflow dropdown using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority field from the dropdown
    Then Update Priority dropdown using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify Uploading image in the Upload photos/images field
    Then Update the Upload image from the image path using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Update Attach the file name using the sheetname "Edit RFI" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the update button
    Then RFI should be Updated

  #Actions -> Edit RFA
  
  @Run
  Scenario: Verify by changing the required field in RFA module under Action
    Then Changing the required field in RFA module under Action using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on RFA Code field
    Then Update valid code on RFA Code field using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on RFA Name field
    Then Update valid name on RFA Name field using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field
    Then Update Description on the field in add RFA using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering valid start date on the field
    Then Update valid start date on the field in add RFA using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Entering valid End date on the field
    Then Update valid End date on the field in add RFA using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Selecting Workflow from the drop-down
    Then Update Workflow from the drop-down in add RFA using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Selecting priority from the drop-down
    Then Update priority from the drop-down in add RFA using sheetname "Edit RFA" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down under checklist and attaching the files
    Then Udpate Attach files from the drop-down and attaching the files using sheetname "Edit RFA" and rownumber 0
    Then Clicking on update button to update a RFA for the project

  #=====Attachments Module========#
  #Attachments-> Edit Form -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the Form
    Then filtering the required Form and clicking on it using sheetname "Edit Form" and rownumber 0
    Then Changing the required field in Form using sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify entering from date
    Then Update the from date using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify entering due date
    Then Update the due date using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify entering location
    Then Update the locationname using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify entering description
    Then Update description using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify user click the Add work button
    Then Click Edit Work button

  @Run
  Scenario: Verify entering add work details
    Then Update work details using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in work pop up
    Then Click Update button to save work details

  @Run
  Scenario: Verify user click the Add Material button
    Then Click Edit Material button

  @Run
  Scenario: Verify entering add material details
    Then Update material details using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in material popup
    Then Click Update button to save material details

  @Run
  Scenario: Verify user click the Add Equipment button
    Then Click Edit Equipment button

  @Run
  Scenario: Verify entering add Equipment details
    Then Update Equipment details using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify user click the save button in Equipment popup
    Then Click Update button to save Equipment details

  @Run
  Scenario: Verify user entering Notes
    Then Update Notes using the sheetname "Edit Form" and rownumber 0

  @Run
  Scenario: Verify user created form
    Then click the Update button

  #Attachments -> Edit CheckList
  
  @Run
  Scenario: Verify by Entering values in checklist fields and items
    Then Entering values in checklist fields and items using sheetnames "Edit checklist" and "Edit checklist items" with rownumber 0

  @Run
  Scenario: Verify by Entering valid checklist code on checklist Code field in check list
    Then Update valid code on checklist Code field using sheetname "Edit checklist" and rownumber 0

  @Run
  Scenario: Verify by Entering valid checklist Name on checklist Name field in check list
    Then Update valid Name on checklist Name field using sheetname "Edit checklist" and rownumber 0

  @Run
  Scenario: Verify by Entering values under Checklist Item Fields
    Then Update values under Checklist Item Fields using sheetname "Edit checklist items" and rownumber 0
    Then Click on Update Button to update checklist

  #Attachments -> Edit BOM/BOQ
  
  @Run
  Scenario: Verify by changing the required field in BOM_BOQ module under Attachments
    Then Changing the required field in BOM_BOQ module under Attachments using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Selecting Parent BOM/BOQ name from the drop-down in BOM/BOQ
    Then Update Parent BOM/BOQ name from the drop-down in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid code on BOM/BOQ Code field in BOM/BOQ
    Then Update valid code on BOM/BOQ Code field using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid name on Name field in BOM/BOQ
    Then Update valid name on Name field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Selecting workflow on the field in BOM/BOQ
    Then Update workflow on the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Selecting priority from the drop-down in BOM/BOQ
    Then Update priority from the drop-down in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid unit field from the drop-down in BOM/BOQ
    Then Update valid unit field from the drop-down in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimated Quantity in the field in BOM/BOQ
    Then Update valid Estimated Quantity in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Estimated Price per unit in the field in BOM/BOQ
    Then Update valid Estimated Price per unit in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  #@Run
  Scenario: Verify by Estimated Total value in the field in BOM/BOQ
  #Then Verifying Estimated Total value in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0
  
  @Run
  Scenario: Verify by Entering valid Ordered Quantity in the field in BOM/BOQ
    Then Update valid Ordered Quantity in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Quoted Price per unit in the field in BOM/BOQ
    Then Update valid Quoted Price per unit in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  #@Run
  Scenario: Verifying the Quoted Total value in the field in BOM/BOQ
  #Then Verifying the Quoted Total value in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0
  
  @Run
  Scenario: Verify by Entering valid Actual Quantity in the field in BOM/BOQ
    Then Update valid Actual Quantity in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid Actual Price per unit in the field in BOM/BOQ
    Then Update valid Actual Price per unit in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  #@Run
  Scenario: Verifying the Actual Total value in the field in BOM/BOQ
  #Then Verifying the Actual Total value in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0
  
  @Run
  Scenario: Verify by Entering valid Remarks in the field in BOM/BOQ
    Then Update valid Remarks in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Entering valid GUID in the field in BOM/BOQ
    Then Update valid GUID in the field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by uploading valid QR code file in the Attach QR code field in BOM/BOQ
    Then Update Uploading valid QR code file in the Attach QR code field in BOM/BOQ using sheetname "Edit BOMBOQ" and rownumber 0

  @Run
  Scenario: Verify by Clicking on Add Properties button and entering values in the field Property name and Property value in BOM/BOQ
    Then Clicking on Add Properties button to update and entering values in the field Property name and Property value using sheetname "Edit BOMBOQ" and rownumber 0
    Then Clicking on Update button to Update BOM for the project

  #=====Share Module========#
  #Share-> Edit Submittals -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the Submittals
    Then filtering the required Submittals and clicking on it using sheetname "Edit Submittals" and rownumber 0
    Then Changing the required field in Submittals using sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid code
    Then Update the Submittalcode using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid name
    And Update the submittalname using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Spec Section
    And Update the Spec Section dropdown using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Sub Spec Section
    And Update the Sub Spec Section dropdown using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Description
    Then Update the Descriptions using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Type
    Then Update the Type dropdown using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow
    Then Update the Workflow for submittal dropdown using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Due Date
    Then Update Due Date using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority
    Then Update the Priority dropdown using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required Date
    Then Update Required Date using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required approval Date
    Then Update Required approval Date using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Required on jobsite Date
    Then Update Required on jobsite Date using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Lead time
    Then Update Lead time using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Update Attach file name using the sheetname "Edit Submittals" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click Update button in the screen
    Then Submittals should be Updated

  #Share-> Edit Transmittals -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the Transmittals
    Then filtering the required Transmittals and clicking on it using sheetname "Edit Transmittals" and rownumber 0
    Then Changing the required field in Transmittals using sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify entering valid code
    Then Update the Transmittalcode using the sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify entering valid name
    And Update the Transmittalname using the sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify entering valid Description
    Then Update the Descriptions of transmittal using the sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow
    Then Update the Workflow for transmittal dropdown using the sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files option
    Then Update Attach the file by the filename using the sheetname "Edit Transmittals" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the Update button on the screen
    Then Transmittals should be Updated

  #Share -> Edit Meeting
  
  @Run
  Scenario: Verify by changing the required field in Meeting module under Share
    Then Changing the required field in Meeting module under Share using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering meeting name on Name field in Edit Meeting
    Then Update meeting name on Name field in add Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Date on date field in Edit Meeting
    Then Update Meeting Date on date field in add Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Time on date field in Edit Meeting
    Then Update Meeting Time on date field in add Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Meeting Duration hours and minutes field in Edit Meeting
    Then Update Meeting Duration hours and minutes field in add Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Description on the field Edit Meeting
    Then Update Description on the field in add Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Entering Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button Edit Meeting
    Then Update Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button in Edit Meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Selecting the selected Participants from Select Users and Selected Group of Users in Add meeting
    Then Update the selected Participants from Select Users and Selected Group of Users in Edit meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Uploading an image in Edit meeting
    Then Update by Uploading an Image in the field in Edit meeting using sheetname "Edit Meeting" and rownumber 0

  @Run
  Scenario: Verify by Selecting Attach files from the drop-down under checklist and attaching the files in Edit Meeting
    Then Update Selecting Attach files from the drop-down and attaching the files in Edit Meeting using sheetname "Edit Meeting" and rownumber 0
    Then Clicking on Update button to update a Meeting for the project

  #=====Folder Module=====#
  #Folder -------> Kamal
  
  @Run
  Scenario: Verify the user is able to edit the foldername
    Given filtering the required Folder and clicking on it using sheetname "Edit Folder" and rownumber 0
    Then Click the menu button on the folder using sheetname "Edit Folder" and rownumber 0
    Then click the Rename button
    Then Update the foldername using the sheetname "Edit Folder" and rownumber 0
