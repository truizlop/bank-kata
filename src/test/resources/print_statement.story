Narrative:
As a user
I want to get my account statement
So that I can check the latest transactions I made and my balance

Scenario: The user performs some transactions and print a statement
Given the user has an empty account
When she makes a deposit of 1000 on 18/04/2016
And she makes a withdrawal of 200 on 20/04/2016
And she makes a deposit of 500 on 21/04/2016
Then she should see a statement like
date | deposit | withdrawal | balance
21/04/2016 | 500.00 | - | 1300.00
20/04/2016 | - | 200.00 | 800.00
18/04/2016 | 1000.00 | - | 1000.00