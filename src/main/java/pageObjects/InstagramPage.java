package pageObjects;

import org.openqa.selenium.WebDriver;

public class InstagramPage extends Page{
    private String title = "EPAM Global (@epamsystems) • Фото и видео в Instagram";

    public InstagramPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTitle() {
        return title.equals(getTitle());
    }
}
