package Pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class Login_page {

    //initialize for web driver
    WebDriver driver;

    //constructor
    public Login_page(WebDriver driver) {
        this.driver = driver;
    }

/* ******************************************************************************************************************/
/* *********************************                  Login page                  ***********************************/
/* ******************************************************************************************************************/
    public void Navigate_login_page(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
    }


    public WebElement Valid_Email(){

        return driver.findElement(By.id("input-email"));
    }

    public WebElement Invalid_Email(){
        return driver.findElement(By.id("input-email"));
    }


    public WebElement Valid_Password(){
        return driver.findElement(By.id("input-password"));
    }

    public WebElement Login_Btn(){
        return driver.findElement(By.xpath("//input[@type=\"submit\"]"));
    }

    public boolean Valid_Login(){
        Assert.assertEquals(driver.getCurrentUrl() , "https://awesomeqa.com/ui/index.php?route=account/account");
        return (Objects.equals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account"));
    }

    public void Invalid_Login(){
        String Expected = "Warning: No match for E-Mail Address and/or Password.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

/* *****************************************************************************************************************/
/* ****************************                  Forgot_Password page                  *****************************/
/* *****************************************************************************************************************/



    public WebElement Enters_Valid_Email_In_Forgotten_Password_Page(){
        return driver.findElement(By.name("email"));
    }

    public WebElement Enters_In_Valid_Email_In_Forgotten_Password_Page(){
        return driver.findElement(By.name("email"));
    }

    public WebElement Forgotten_Password_Btn(){
        return driver.findElements(By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/forgotten\"]")).getFirst();
    }

    public WebElement Forgotten_Password_Page_Continue_Btn(){
        return driver.findElement(By.xpath("//input[@type=\"submit\"]"));
    }

    public void Confirmation_Msg(){
        String Expected = "An email with a confirmation link has been sent your email address.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-login\"]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void Forgot_Msg ()
    {
        String Expected = "Enter the e-mail address associated with your account. Click submit to have a password reset link e-mailed to you.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }
    public void Error_Msg_Of_Forget_Invalid_Email(){
        String Expected = "Warning: The E-Mail Address was not found in our records, please try again!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

/* *****************************************************************************************************************/
/* ***************************                  search for any product                  ****************************/
/* *****************************************************************************************************************/


    public void Navigate_Home_page(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public WebElement Clicks_On_Search_TextBox(){
        return driver.findElement(By.xpath("//input[@type=\"text\"]"));
    }

    public WebElement Clicks_On_Search_Button(){
        return driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));                  /* **********************/
    }

    public void Find_The_Desired_Product(){

        String Expected = "Search - Apple Cinema 30";
        String Actual = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
        //Assert.assertTrue(driver.findElement(By.className("col-sm-6 text-right")).isDisplayed());
    }

    public WebElement Currency_Drop_Down_List()
    {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div"));
    }

    public WebElement Currency_US_Selected()
    {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]"));
    }

    public void Assert_Currency_Is_US()
    {
        String Expected = "$";
        String Actual = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public WebElement Currency_Euro_Selected()
    {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]"));
    }

    public void Assert_Currency_Is_Euro()
    {
        String Expected = "€";
        String Actual = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public WebElement Hovering_Randomly_El1()
    {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]"));
    }

    public WebElement Hovering_Randomly_El2()
    {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]"));
    }

    public WebElement Hovering_Randomly_El3()
    {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]"));
    }

    public WebElement Hovering_Randomly_El4()
    {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div"));
    }

    public WebElement Add_Item_To_Wish_list()
    {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[2]"));
    }

    public void See_A_Wishlist_Confirmation_Msg()
    {
        String Expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).isDisplayed());
    }

    public WebElement AddItemToCompareList()
    {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[3]"));
    }

    public void CompareListConfirmationMsg()
    {
        String Expected = "Success: You have added Apple Cinema 30\" to your product comparison!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }


    public WebElement Add_Item_To_Shipping_Cart()
    {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
    }

    public void See_A_Shipping_Cart_Confirmation_Msg()
    {
        String Expected = " Success: You have added iMac to your shopping cart!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println(Expected);
        System.out.println(Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }


}









