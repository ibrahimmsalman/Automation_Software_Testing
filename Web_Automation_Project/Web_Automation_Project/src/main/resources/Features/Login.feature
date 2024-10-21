Feature: Test Login Functionality

  # TC01

  Scenario: Validate Login using valid credentials
    Given  User Navigate To Login Page
    When   User Enters Valid Email
    And    User Enters Valid Password
    And    User Clicks On Login Button
    Then   User Should Login Successfully


  #TC02

  Scenario: Validate Appearance Of Error Msg Using Invalid Email
    Given  User Navigate To Login Page
    When   User Enters Invalid Email
    And    User Enters Valid Password
    And    User Clicks On Login Button
    Then   User Should See Error Msg

  #TC03
  Scenario: Validate The Forget Password Button Functionality
    Given  User Navigate To Login Page
    When   User Clicks On Forget Password Button
    Then   User Should See confirmation Msg of Forget Button Clicking

  #TC04
  Scenario: Validate The Forget Password Functionality with valid email
    Given  User Navigate To Login Page
    When   User Clicks On Forget Password Button
    And    User Enters Valid Email in Forgotten Password Page
    And    User Clicks On Continue Button
    Then   User Should See confirmation Msg

  #TC05
  Scenario: Validate The Forget Password Functionality with invalid email
    Given  User Navigate To Login Page
    When   User Clicks On Forget Password Button
    And    User Enters inValid Email in Forgotten Password Page
    And    User Clicks On Continue Button
    Then   User Should See Error Msg of Forget Button

  #TC06
  Scenario: Logged users could search for any product
    Given  User Navigate To Home Page
    When   User Clicks On Search TextBox
    And    User Enter The Desired Product
    And    User Clicks On Search Button
    Then   User Can Find The Desired Product

  #TC07
  Scenario: Logged Users could switch currencies to US
    Given User Navigate To Home Page
    When  User Clicks On Drop Down List Of Currencies
    And   User Clicks On US Currency
    Then  User Can Find Prices In US Currency

  #TC08
  Scenario: Logged Users could switch currencies to Euro
    Given User Navigate To Home Page
    When  User Clicks On Drop Down List Of Currencies
    And   User Clicks On Euro Currency
    Then  User Can Find Prices In Euro Currency

  #TC09
  Scenario: Hovering to main and sub categories randomly
    Given User Navigate To Home Page
    When  User Can Hover Randomly to elements

#######################################################################################################################
  #TC10
  Scenario: Logged Users could Add Item To Wishlist
    Given  User Navigate To Home Page
    When   User Clicks On Search TextBox
    And    User Enter The Desired Product
    And    User Clicks On Search Button
    And    User Can Add Item To Wishlist
    Then   User Can See A Wishlist Confirmation Msg
#######################################################################################################################


#TC11
  Scenario: Logged Users could Add Item To Compare List
    Given  User Navigate To Home Page
    When   User Clicks On Search TextBox
    And    User Enter The Desired Product
    And    User Clicks On Search Button
    And    User Can Add Item To Compare List
    Then   User Can See A Compare List Confirmation Msg

#TC12
  Scenario: Logged Users could Add Item To Shipping Cart
    Given  User Navigate To Home Page
    When   User Clicks On Search TextBox
    And    User Enter The Desired Product iMac
    And    User Clicks On Search Button
    And    User Can Add Item To Shipping Cart
    Then   User Can See A Shipping Cart Confirmation Msg