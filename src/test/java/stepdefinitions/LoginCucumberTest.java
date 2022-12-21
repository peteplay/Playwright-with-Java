package stepdefinitions;

import com.microsoft.playwright.*;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Paths;

public class LoginCucumberTest extends BaseClass {

    LoginPage login;
    HomePage home;
    Page page = browser.newPage();


/*

    Use the following lines to change the size of the screen
    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(280, 1024));
    Page page = context.newPage();
*/




    @Given("User launched SwagLabs application")
    public void setUp() {
        page.navigate("https://www.saucedemo.com/");
        home = new HomePage(page);
        login = new LoginPage(page);
/*
        // take a screenshot
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/homepage.png"))
                .setFullPage(true));
        */
    }

    @When("User verify the Page title")
    public void verifyPageTitle() {
        String title = login.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    //Login into the application
    @When("User logged in the app using username {string} and password {string}")
    public void loginIntoTheApplication(String username,String password ) {
        login.loginIntoApplication(username, password);
    }

    //Verify product name after login
    @Then("User verify the product name {string}")
    public void verifyProductsName(String productname) {
        String productName = home.productName();
        Assert.assertEquals(productName, productname);
    }

    //Logout from application
    @Then("User logout from the application")
    public void logoutFromApplication() {
        login.logoutApplication();
    }
}