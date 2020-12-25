package pageObjects;

import org.openqa.selenium.WebDriver;

public class ContactPage extends Page{
    private String title = "Learn more about EPAM and Contact Us | EPAM";

    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle() {
        return title.equals(getTitle());
    }
}
