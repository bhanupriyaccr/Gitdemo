Feature: Application Login

Scenario Outline: Home Page Default login

Given Intilalize the browser
And Navigate to "http://www.qaclickacademy.com" page
And Click on Login button
When user log in  with <username> and <password>
Then Verify the user is landed correctly
And close browsers
Examples:
|username  |password |
|test99@gmail.com |123456 |
|priya@yahoo.com |123456 |