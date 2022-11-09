package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class HomePage
{
    // protected class accessible to the current package
    protected static WebDriver driver;

    // Method for unique id
    public String getTimeStamp()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
    // Method for click
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    // Method for entering text
    public void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // Method for Get Text line in output
    public String getTextFormElement(By by)
    {
        return driver.findElement(by).getText();
    }

    // Open Website
    @BeforeTest
    public void openBrowser()
    {
        // To do Auto-generated method sub
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // For keep fullscreen
        driver.manage().window().maximize();
        // Enter URL
        driver.get("https://demo.nopcommerce.com/");

    }

    // close website
    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }

    @Test
    public void verifyUserShouldBeAbleToRegister()
    {
        // Click on Register
        clickOnElement(By.className("ico-register"));
        // Enter First Name
        typeText(By.id("FirstName"),"Rajesh");
        // Enter Last Name
        typeText(By.id("LastName"),"Patel");
        // Enter Email with unique id
        typeText(By.id("Email"),"rajeshpatelhh"+getTimeStamp()+"@gmail.com");
        // Enter Password
        typeText(By.id("Password"),"Test&1234");
        // Enter Confirm Password
        typeText(By.id("ConfirmPassword"),"Test&1234");
        // Click on Register Button
        clickOnElement(By.name("register-button"));

        // Get Text line after successfully Registartion in output
        String regMsg = getTextFormElement(By.className("result"));
        System.out.println(regMsg);
    }

    @Test
    public void verifyUserShouldBeAbleTOSeeProductOfDesktopOnComputersPage()
    {
        // Click on Computers on Homepage
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        // Click on Desktops on Computers page
        clickOnElement(By.xpath("//h2/a[@href=\"/desktops\"]"));

        // Get as a text in output products of desktop(computers)
        String productComputer1 = getTextFormElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));
        System.out.println(productComputer1);
        // Get as a text in output products of desktop(computers)
        String productComputer2 = getTextFormElement(By.xpath("//h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        System.out.println(productComputer2);
        // Get as a text in output products of desktop(computers)
        String productComputer3 = getTextFormElement(By.xpath("//h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        System.out.println(productComputer3);
    }

    @Test
    public void verifyUserShouldBeAbleTogoNopCommerceNewReleaseOfNewsAndSuccessfullyAbleToAddComment()
    {
        // Click on Details of nopCommerce new release
        clickOnElement(By.xpath("//div[@class=\"news-head\"]/a[@href=\"/nopcommerce-new-release\"]"));
        // Enter Title on nopCommerce new release page
        typeText(By.id("AddNewComment_CommentTitle"),"Product");
        // Enter comment on nopCommerce new release page
        typeText(By.id("AddNewComment_CommentText"),"All products are good.");
        // Click on New Comment on nopCommerce new release page
        clickOnElement(By.name("add-comment"));


        // Get Text line after successfully comments in output
        String newsComment = getTextFormElement(By.className("result"));
        System.out.println(newsComment);

    }
    @Test
    public void verifyUserShouldBeAbleToSeeCategoriesOfHomePage()
    {
        // Print categories of homepage
        System.out.println("Home-Page Categories");

        // Get name of Home-page Categories in output
        String homeCate1 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]"));
        System.out.println(homeCate1);
        // Get name of Home-page Categories in output
        String homeCate2 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"));
        System.out.println(homeCate2);
        // Get name of Home-page Categories in output
        String homeCate3 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]"));
        System.out.println(homeCate3);
        // Get name of Home-page Categories in output
        String homeCate4 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]"));
        System.out.println(homeCate4);
        // Get name of Home-page Categories in output
        String homeCate5 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]"));
        System.out.println(homeCate5);
        // Get name of Home-page Categories in output
        String homeCate6 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]"));
        System.out.println(homeCate6);
        // Get name of Home-page Categories in output
        String homeCate7 = getTextFormElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]"));
        System.out.println(homeCate7);
    }

    @Test
    public void verifyUnregistredUserShouldNotAbleToReferAProductToAFriend()
    {
        // Click on Apple MacBook Pro 13-inch on Homepage
        clickOnElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]"));
        // Click on Email a friend on Apple MacBook Pro 13-inch page
        clickOnElement(By.className("email-a-friend"));
        // Enter friend's email on emailafriend page
        typeText(By.className("friend-email"),"bindupatel"+getTimeStamp()+"@gmail.com");
        // Enter your email on emailafriend page
        typeText(By.className("your-email"),"hayatipatelhh@gmail.com");
        // Enter prsonal message on emailafriend page
        typeText(By.id("PersonalMessage"),"Hi..");
        // Click on SEND EMAIL on emailafriend page
        clickOnElement(By.name("send-email"));

        // Get Text line after click SEND EMAIL in output
        String emailMsg = getTextFormElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        System.out.println(emailMsg);

    }
}
