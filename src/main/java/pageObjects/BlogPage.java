package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BlogPage extends Page{
    private String title = "Flip the Script Careers Blog | EPAM";
    private final By searchBy = By.cssSelector("div[class='title'] > h1");

    public BlogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle() {
        return title.equals(getTitle());
    }

    public boolean checkCenterTitle(String titleText) {
        WebElement centerTitle = webDriver.findElement(searchBy);
        return titleText.equals(centerTitle.getText());
    }
}
