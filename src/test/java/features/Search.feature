Feature: Search for Products

@validproduct @smoke @regression @all @search
Scenario: Search for a valid product
Given Open the Application in any browser for searching
When I enter valid product into the search box field
And I click on Search button
Then Searched Product should be displayed in the search results

@invalidproduct @regression @all @search
Scenario: Search for an invalid product
Given Open the Application in any browser for searching
When I enter invalid product into the search box field
And I click on Search button
Then No Product available should be displayed in Search results

@noproduct @regression @all @search
Scenario: Search without providing any product details
Given Open the Application in any browser for searching
When I dont enter any product name into the search box field
And I click on Search button
Then No Product available should be displayed in Search results