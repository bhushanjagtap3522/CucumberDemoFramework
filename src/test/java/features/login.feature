Feature: Login

@Login
Scenario: Perform valid login
Given User is on login page
When User performs login with username "bhushan_3522" and password "tu3f1011032"
Then User is on Home Page