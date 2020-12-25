package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HowWeDoItPage extends Page{
    private String title = "How We Do It | Agile Product Engineering Services | EPAM";
    private final By homeButtonSelector = By.cssSelector(".header__logo-container");

    public HowWeDoItPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle() {
        return title.equals(getTitle());
    }

    public void openHomePage() {
        WebElement homePageButton = webDriver.findElement(homeButtonSelector);
        homePageButton.click();
    }

}
