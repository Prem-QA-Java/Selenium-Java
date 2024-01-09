Feature: Sorting Products
As a user the resutls of the products should sort accounding to the selected filter

Background: 
Given Lunch URL 'https://www.saucedemo.com/'

Scenario: Select Name (A-Z) sorting
And give user name: 'standard_user' and passowrd: 'secret_sauce'
And click on login
Then click on sorting dropdown and select 'Name (A to Z)' sorting  value
Then verify the products should order by a-z

Scenario: Select Name (Z-A) sorting
And give user name: 'standard_user' and passowrd: 'secret_sauce'
And click on login
Then click on sorting dropdown and select 'Name (Z to A)' sorting  value
Then verify the products should order by z-a

Scenario: Select Price (low to high) sorting
And give user name: 'standard_user' and passowrd: 'secret_sauce'
And click on login
Then click on sorting dropdown and select 'Price (low to high)' sorting  value
Then verify the products should order by price low-high

Scenario: Select Price (high to low) sorting
And give user name: 'standard_user' and passowrd: 'secret_sauce'
And click on login
Then click on sorting dropdown and select 'Price (high to low)' sorting  value
Then verify the products should order by price high-low