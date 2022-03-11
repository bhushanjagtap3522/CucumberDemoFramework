Feature: HomePage Feature

@HomePage
Scenario: Verify Navigation Bar items
Given User is on Home Page
Then User verifies items on navigation menu
|HOME|CALENDAR|COMPANIES|CONTACTS|DEALS|TASKS|CASES|CALL|EMAIL|TEXT/SMS|PRINT|CAMPAIGNS|DOCS|FORMS|REPORTS|

@HomePage
Scenario: Verify calendar widget is displayed
Given User is on Home Page
Then User verifies presence of calendar widget

@HomePage
Scenario: Verify calendar widget shows correct month and year
Given User is on Home Page
Then Calendar widget should show month "March" and year "2022"