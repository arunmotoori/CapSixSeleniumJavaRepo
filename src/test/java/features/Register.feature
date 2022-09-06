Feature: Creating new account in the application as a User

@allfields @smoke @regression @all @register
Scenario: Regiser an account by providing all fields
Given Open the Application in any browser for registration
And I navigate to Register Account page
When I enter all the details into the fields
|firstname|Arun										|
|lastname	|Motoori								|
|phone		|1234567890							|
|password	|12345									|
And I select Privacy Policy checkbox field
And I click on Continue button
Then New User Account should get created
