package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends AbstractPage {
    @FindBy(xpath = "//div[@aria-label=\"selenium.tester@mail.ru\"]")
    WebElement dropdown;
    @FindBy(xpath = "//a[@href=\"//auth.mail.ru/cgi-bin/logout?next=1&lang=ru_RU&page=https%3A%2F%2Fmail.ru%2F%3Ffrom%3Dlogout\"]")
    WebElement logoutButton;
    @FindBy(xpath = "//input[@name=\"login\"]")
    WebElement loginInputForm;

    Actions actions = new Actions(getDriver());

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public LogoutPage pressDropdown() {

        actions.click(dropdown).build().perform();
        return this;
    }

    public LogoutPage pressLogout() {
        waitForElementPresence(logoutButton);
        actions.click(logoutButton).build().perform();
        return this;
    }

    public boolean isLogout() {
        waitForElementPresence(loginInputForm);
        return loginInputForm.isDisplayed();
    }
}
