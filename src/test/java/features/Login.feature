Feature: User Login

Users using the application should be able to login and use the Software

Background:
Given Open the Application in any browser
And Navigate to Login page

@validcredentials @smoke @regression @all @login
Scenario: Login with valid credentials
When User enters valid credentials into the email and password fields
And User clicks on Login button
Then Verify user is able to successfully login

@invalidcredentials @regression @all @login
Scenario: Login with invalid credentials
When User enters invalid credentials into the email and password fields
And User clicks on Login button
Then Verify user login is unsuccessfull

@datadriven @all @login
Scenario Outline: Login with different user credetials
When User enters username say "<username>" and password say "<password>" into the fields
And User clicks on Login button
Then Verify login status "<loginstatus>" of the User
Examples:
|username											|password		|loginstatus|
|amotooricap9@gmail.com				|12345			|success		|
|amotooricap9asf4543@gmail.com|1234567890	|failure		|
|amotooricap1@gmail.com				|12345			|success		|
 

