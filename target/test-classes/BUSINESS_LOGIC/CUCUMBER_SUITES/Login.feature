Feature: Login functionality

  Background: open application
    Given user open chrome browser with exe as "D:\Software Testing\TutorialsNinja\TutorialsNinja\src\test\resources\DRIVERS\chromedriver.exe"
    Given user open url as "http://tutorialsninja.com/demo/"
    Given user click on My Account
    Given user click on Login button

  @SmokeTest
  Scenario: Login functionality with valid username and valid password
    When user enter "ravibhalerao9970@gmail.com" as username
    When user enter "ravikiran" as password
    When user click on Login
    Then user is logged in successfully

  @RegressionTest
  Scenario: Login functionality with valid username and invalid password
    When user enter "ravibhalerao9970@gmail.com" as username
    When user enter "raviKirn" as password
    When user click on Login

  Scenario: Login functionality with invalid username and valid password
    When user enter "Ravibhlerao9970@gmail.com" as username
    When user enter "ravikiran" as password
    When user click on Login

  Scenario: Login functionality with invalid username and invalid password
    When user enter "Ravibhalerao997@gmail.com" as username
    When user enter "rAikiran" as password
    When user click on Login
