package stepDefs;
import cucumber.api.java.ca.I;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class NavBarOpeningStepDef{
    WebDriver webDriver;

    MainPage mainPage;
    BlogPage blogPage;
    HowWeDoItPage howWeDoItPage;
    ContactPage contactPage;
    InstagramPage instagramPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        mainPage = new MainPage(webDriver);
        blogPage = new BlogPage(webDriver);
        howWeDoItPage = new HowWeDoItPage(webDriver);
        contactPage = new ContactPage(webDriver);
        instagramPage = new InstagramPage(webDriver);
    }

    @Given("User has opened main page")
    public void userHasOpenedMainPage() {
        mainPage.openPage("https://www.epam.com/");
    }

    @When("User opens blog page")
    public void userOpensBlogPage() {
        mainPage.openBlogPage();
    }

    @Then("Blog page opens")
    public void blogPageOpens() {
        Assertions.assertTrue(blogPage.checkTitle());
    }

    @And("User sees Greetings, Innovators!")
    public void userSeesGreetingsInnovators() {
        String centerTitle = "Greetings, Innovators!";
        Assertions.assertTrue(blogPage.checkCenterTitle(centerTitle));
    }

    @After
    public void stopDriver() {
        webDriver.close();
    }

    @When("User clicks contact us button")
    public void userClicksContactUsButton() {
        mainPage.openContactPage();
    }

    @Then("Contact page opens")
    public void contactPageOpens() {
        Assertions.assertTrue(contactPage.checkTitle());
    }

    @When("User clicks contact selection button")
    public void userClicksContactSelectionButton() {
        mainPage.clickSelectorButton();
    }


    @And("Choose ukrainian")
    public void chooseUkrainian() {
        mainPage.changeToUkrainian();
    }


    @Then("User see ukrainian main page")
    public void userSeeUkrainianMainPage() {
        Assertions.assertFalse(contactPage.checkTitle());
    }

    @When("User clicks how we do it button")
    public void userClicksHowWeDoItButton() {
        mainPage.openHowWeDoItPage();
    }

    @Then("How we do it page opens")
    public void howWeDoItPageOpens() {
        Assertions.assertTrue(howWeDoItPage.checkTitle());
    }

    @And("User clicks home page button")
    public void userClicksHomePageButton() {
        howWeDoItPage.openHomePage();
    }

    @Then("User backs to home page")
    public void userBacksToHomePage() {
        Assertions.assertTrue(mainPage.checkTitle());
    }

    @When("User clicks instagram image")
    public void userClicksInstagramImage() {
        mainPage.openInstagram();
    }

    @Then("User redirects to instagram")
    public void userRedirectsToInstagram() {
        instagramPage.checkTitle();
    }

    @Then("User clicks search button")
    public void userClicksSearchButton() {
        mainPage.clickSearchButton();
    }

    @And("User writes Blockchain")
    public void userWritesBlockchain() {
        mainPage.addText();
    }

    @And("User clicks find button")
    public void userClicksFindButton() {
        mainPage.acceptFind();
    }


    @Then("User sees result")
    public void userSeesResult() {
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.epam.com/search?q=Blockchain"));
    }
}
