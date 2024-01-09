Feature: Login page

Background:
Given Lunch URL 'https://www.saucedemo.com/'

Scenario: Successfully login
And give user name: 'standard_user' and passowrd: 'secret_sauce'
And click on login
Then vaild login successful

Scenario: locked user
And give user name: 'locked_out_user' and passowrd: 'secret_sauce'
And click on login
Then vaild locked user text below password box 'Epic sadface: Sorry, this user has been locked out.'
And click on cross to close the popup

Scenario: invaild user
And give user name: 'test' and passowrd: 'secret_sauce'
And click on login
Then vaild locked user text below password box 'Epic sadface: Username and password do not match any user in this service'
And click on cross to close the popup