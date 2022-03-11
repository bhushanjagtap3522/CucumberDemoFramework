Feature: Create new contact

@Contact
Scenario: Navigate to new contact page
Given User is on Home Page
When User clicks on New Contact link
Then User is on New Contact page

@Contact
Scenario Outline: Create new contacts
Given User is on Home Page
When User clicks on New Contact link
And Create a contact with firstname "<firstname>" lastname "<lastname>" mobile "<mobile>" and email "<email>"
Then User is created with firstname "<firstname>" lastname "<lastname>" mobile "<mobile>" and email "<email>"

Examples:
|firstname|lastname|mobile|email|
|Rohit|Sharma|1234567890|rsharma@test.com|
|Virat|Kohli|1234567890|vkohli@test.com|
|Ravindra|Jadeja|1234567890|rjadeja@test.com|
|Sachin|Tendulkar|1234567890|stendulkar@test.com|