package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraftsLetterPage extends AbstractPage{
    @FindBy(xpath = "//span[@tabindex=\"570\"]")
    WebElement sendMail;
    @FindBy(xpath = "//span[@title=\"selenium.tester@mail.ru\"][1]")
    WebElement lastSaved;
    @FindBy(xpath = "//span[@class=\"text--1tHKB\"]")
    WebElement addresseeCheck;
    @FindBy(xpath = "//a[@href=\"/sent/\"]")
    WebElement sentButton;
    @FindBy(xpath = "//span[@class=\"ll-crpt\"]")
    WebElement mailSent;
    @FindBy(xpath = "//span[@tabindex=\"1000\"]")
    WebElement closeButtonForLetterSentWindow;

    Actions actions = new Actions(getDriver());

    public DraftsLetterPage(WebDriver driver) {
        super(driver);
    }

    public DraftsLetterPage openLastSaved() {
        waitForElementPresence(lastSaved);
        lastSaved.click();
        return this;
    }

    public String verifyAddressee() {
        waitForElementPresence(addresseeCheck);
        return addresseeCheck.getText();
    }

    public DraftsLetterPage sendMail() {
        sendMail.click();
        return this;
    }

    public DraftsLetterPage closeLetterSentWindow() {
        waitForElementPresence(closeButtonForLetterSentWindow);
        actions.click(closeButtonForLetterSentWindow).build().perform();
        return this;
    }

    public boolean verifyMailIsSent() {
        waitForElementPresence(sentButton);
        actions.click(sentButton).build().perform();
        waitForElementPresence(mailSent);
        return isElementPresent(mailSent);
    }
}
