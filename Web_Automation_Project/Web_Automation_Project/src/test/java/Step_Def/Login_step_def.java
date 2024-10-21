package Step_Def;

import Pages.Login_page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_step_def {
    // WebDriver instance to control the browser
    WebDriver driver;
    // Instance of the Login_page class for interacting with the login page
    Login_page loginpage_obj;
    Actions act;
    boolean login_state = false;       // the user is not logging in the website

    // Method to set up preconditions before each test scenario
    @Before
    public void precondition() {
        driver = new ChromeDriver();
        // Initialize the ChromeDriver and maximize the browser window
        driver.manage().window().maximize();
        // Create an instance of Login_page with the WebDriver
        loginpage_obj = new Login_page(driver);
        //
        act = new Actions(driver);
    }


    @After
    public void Quit_Browser() throws InterruptedException {
        Thread.sleep(200);
        driver.quit();
    }


    /* ****************************************************************************************************************/
    /* *****************************   Scenario: Validate Login using valid credentials   *****************************/
    /* ****************************************************************************************************************/
    // Step definition for navigating to the login page
    @Given("User Navigate To Login Page")
    public void User_Navigate_To_Login_Page() {
        // Directs the user to the login page
        loginpage_obj.Navigate_login_page();
    }

    // Step definition for entering a valid email
    @When("User Enters Valid Email")
    public void User_Enters_Valid_Email() {
        // Accepts valid email input
        loginpage_obj.Valid_Email().sendKeys("fipipay641@rowplant.com");                                              /*need to complete*/
    }

    // Step definition for entering a valid password
    @And("User Enters Valid Password")
    public void User_Enters_Valid_Password() {
        // Accepts valid password input
        loginpage_obj.Valid_Password().sendKeys("1234");                                            /*need to complete*/
    }

    // Step definition for clicking the login button
    @And("User Clicks On Login Button")
    public void User_Clicks_On_Login_Button() {
        // Simulates a click on the login button
        loginpage_obj.Login_Btn().click();
    }

    // Step definition for verifying successful login
    @Then("User Should Login Successfully")
    public void User_Should_Login_Successfully() {
        // Verifies that the user has logged in successfully by checking for a valid data message
        loginpage_obj.Valid_Login();
        if (loginpage_obj.Valid_Login()) {
            login_state = true;
        }

    }


    /* ****************************************************************************************************************/
    /* **********************   Scenario: Validate Appearance Of Error Msg Using Invalid Email   **********************/
    /* ****************************************************************************************************************/

    // Step definition for entering an invalid email
    @When("User Enters Invalid Email")
    public void User_Enters_Invalid_Email() {
        // Accepts invalid email input
        loginpage_obj.Invalid_Email().sendKeys("150");                                            /*need to complete*/
    }

    // Step definition for verifying error message on invalid credentials
    @Then("User Should See Error Msg")
    public void User_Should_See_Error_Msg() {
        // Verifies that an appropriate error message is displayed when invalid credentials are entered
        loginpage_obj.Invalid_Login();
    }



    /* ****************************************************************************************************************/
    /* ***********************   Scenario: Validate The Forget Password Button Functionality   ************************/
    /* ****************************************************************************************************************/

    // Step definition for clicking the "Forget Password" button
    @When("User Clicks On Forget Password Button")
    public void UserClicksOnForgetPasswordButton() {
        loginpage_obj.Forgotten_Password_Btn().click();
    }

    @And("User Clicks On Continue Button")
    public void UserClicksOnContinueButton() {
        loginpage_obj.Forgotten_Password_Page_Continue_Btn().click();
    }

    @And("User Enters Valid Email in Forgotten Password Page")
    public void User_Enters_Valid_Email_In_Forgotten_Password_Page() {
        loginpage_obj.Enters_Valid_Email_In_Forgotten_Password_Page().sendKeys("fipipay641@rowplant.com");              /*need to complete*/
    }

    @Then("User Should See confirmation Msg")
    public void User_Should_See_Confirmation_Msg() {
        loginpage_obj.Confirmation_Msg();
    }

    @And("User Enters inValid Email in Forgotten Password Page")
    public void User_Enters_In_Valid_Email_In_Forgotten_Password_Page() {
        loginpage_obj.Enters_In_Valid_Email_In_Forgotten_Password_Page().sendKeys("1231");                         /*need to complete*/
    }

    @Then("User Should See confirmation Msg of Forget Button Clicking")
    public void user_Should_See_Confirmation_Msg_Of_Forget_Button_Clicking() {
        loginpage_obj.Forgot_Msg();
    }

    @Then("User Should See Error Msg of Forget Button")
    public void userShouldSeeErrorMsgOfForgetButton() {
        loginpage_obj.Error_Msg_Of_Forget_Invalid_Email();;
    }

    /* *****************************************************************************************************************/
    /* ***************************                  search for any product                  ****************************/
    /* *****************************************************************************************************************/

    @Given("User Navigate To Home Page")
    public void UserNavigateToHomePage() {
            loginpage_obj.Navigate_Home_page();
    }

    @When("User Clicks On Search TextBox")
    public void User_Clicks_On_Search_TextBox() {
        loginpage_obj.Clicks_On_Search_TextBox().click();
    }

    @And("User Enter The Desired Product")
    public void User_Enter_The_Desired_Product() {
        loginpage_obj.Clicks_On_Search_TextBox().sendKeys("Apple Cinema 30");
    }

    @And("User Clicks On Search Button")
    public void User_Clicks_On_Search_Button() {
        loginpage_obj.Clicks_On_Search_Button().click();
    }

    @Then("User Can Find The Desired Product")
    public void User_Find_The_Desired_Product() {
        loginpage_obj.Find_The_Desired_Product();
    }

    /* ***************************************************************************************************************/
    /* **************************                switch between currencies                 ***************************/
    /* ***************************************************************************************************************/
    @When("User Clicks On Drop Down List Of Currencies")
    public void User_Clicks_On_Drop_Down_List_Of_Currencies() {
        loginpage_obj.Currency_Drop_Down_List().click();
    }

    @And("User Clicks On US Currency")
    public void User_Clicks_On_US_Currency() {
        loginpage_obj.Currency_US_Selected().click();
    }

    @Then("User Can Find Prices In US Currency")
    public void User_Can_Find_Prices_In_US_Currency() {
        loginpage_obj.Assert_Currency_Is_US();
    }

    @And("User Clicks On Euro Currency")
    public void User_Clicks_On_Euro_Currency() {
        loginpage_obj.Currency_Euro_Selected().click();
    }

    @Then("User Can Find Prices In Euro Currency")
    public void User_Can_Find_Prices_In_Euro_Currency() {
        loginpage_obj.Assert_Currency_Is_Euro();
    }



    /* *****************************************************************************************************************/
    /* ***************************                hovering between elements                 ****************************/
    /* *****************************************************************************************************************/
    @When("User Can Hover Randomly to elements")
    public void User_Can_Hover_Randomly_To_Elements() throws InterruptedException {
        WebElement el1 = loginpage_obj.Hovering_Randomly_El1();
        WebElement el2 = loginpage_obj.Hovering_Randomly_El2();
        WebElement el3 = loginpage_obj.Hovering_Randomly_El3();
        WebElement el4 = loginpage_obj.Hovering_Randomly_El4();
        act.moveToElement(el1).perform();
        Thread.sleep(2000);
        act.moveToElement(el2).perform();
        Thread.sleep(2000);
        act.moveToElement(el3).perform();
        Thread.sleep(2000);
        act.moveToElement(el4).perform();
        Thread.sleep(2000);


    }

    @And("User Can Add Item To Wishlist")
    public void userCanAddItemToWishlist() {
        loginpage_obj.Add_Item_To_Wish_list().click();
    }

    @Then("User Can See A Wishlist Confirmation Msg")
    public void User_Can_See_A_Wishlist_Confirmation_Msg() {
        loginpage_obj.See_A_Wishlist_Confirmation_Msg();
    }


    @And("User Can Add Item To Compare List")
    public void userCanAddItemToCompareList() {
        loginpage_obj.AddItemToCompareList().click();
    }

    @Then("User Can See A Compare List Confirmation Msg")
    public void User_Can_See_A_Compare_List_Confirmation_Msg() {
        loginpage_obj.CompareListConfirmationMsg();
    }

    @And("User Enter The Desired Product iMac")
    public void User_Enter_The_Desired_Product_iMac() {
        loginpage_obj.Clicks_On_Search_TextBox().sendKeys("iMac");
    }

    @And("User Can Add Item To Shipping Cart")
    public void User_Can_Add_Item_To_Shipping_Cart() {
        loginpage_obj.Add_Item_To_Shipping_Cart().click();
    }

    @Then("User Can See A Shipping Cart Confirmation Msg")
    public void userCanSeeAShippingCartConfirmationMsg() {
        loginpage_obj.See_A_Shipping_Cart_Confirmation_Msg();
    }

}
