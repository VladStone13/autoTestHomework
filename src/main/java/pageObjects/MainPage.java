package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class MainPage extends Page{
    private final By blogButtonSelector =By.cssSelector("a[href = '/careers/blog']");
    private final By careerButtonSelector = By.cssSelector("a[href = '/careers']");
    private final By howWeDoItButtonSelector = By.cssSelector("a[href = '/how-we-do-it']");
    private final By selectorButtonSelector = By.cssSelector(".location-selector__button");
    private final By ukrainianSelector = By.cssSelector("a[href = 'https://careers.epam.ua']");
    private final By contactButtonSelector = By.cssSelector(".cta-button__text");
    private final By instagramButtonSelector = By.cssSelector("a[href= 'https://www.instagram.com/epamsystems/']");
    private final By searchButtonSelector = By.cssSelector(".header-search__button");
    private final By inputFieldSelector = By.cssSelector(".header-search__input");
    private final By findFieldSelector = By.cssSelector(".header-search__submit");

    private String title = "EPAM | Enterprise Software Development, Design & Consulting";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSearchButton() {
        WebElement searchButton = webDriver.findElement(searchButtonSelector);
        searchButton.click();
    }

    public void acceptFind() {
        WebElement findButton = webDriver.findElement(findFieldSelector);
        findButton.click();
    }

    public void addText() {
        WebElement textForm = webDriver.findElement(inputFieldSelector);
        textForm.sendKeys("Blockchain");
    }

    public void clickSelectorButton() {
        WebElement selectorButton = webDriver.findElement(selectorButtonSelector);
        selectorButton.click();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void openInstagram() {
        Actions actions = new Actions(webDriver);
        WebElement instagramButton = webDriver.findElement(instagramButtonSelector);
        actions.moveToElement(instagramButton).perform();
        instagramButton.click();
    }

    public void changeToUkrainian() {
        WebElement ukrainianButton = webDriver.findElement(ukrainianSelector);

        ukrainianButton.click();
    }

    public void openContactPage() {
        WebElement contactButton = webDriver.findElement(contactButtonSelector);
        contactButton.click();
    }

    public void openHowWeDoItPage() {
        WebElement contactButton = webDriver.findElement(howWeDoItButtonSelector);
        contactButton.click();
    }

    public boolean checkTitle() {
        return title.equals(getTitle());
    }

    public void openBlogPage() {
        Actions actions = new Actions(webDriver);
        WebElement careerButton = webDriver.findElement(careerButtonSelector);
        WebElement blogButton = webDriver.findElement(blogButtonSelector);
        actions.moveToElement(careerButton).perform();
        blogButton.click();
    }
}
