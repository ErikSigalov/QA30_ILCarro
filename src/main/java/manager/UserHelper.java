package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.xml.soap.Text;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm() {

        click(By.xpath("//a[text()=' Log in ']"));
    }


    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
        // click(By.cssSelector("[type='submit']"));
        WebElement submit = wd.findElement(By.cssSelector("[type='submit']"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(submit));

        submit.submit();

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Log in ']"));

    }

    public void logout() {

        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLoggedSuccess() {
        return isElementPresent(By.xpath("//div[@class='dialog-container']"));
    }

    public void clickOkButton() {

        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isErrorMessageWrongFormat() {
        if (isElementPresent(By.xpath("//h2[normalize-space()='Wrong email or password']"))) {

        }
        return true;
    }

    public boolean isButtonPresent() {
        if (isElementPresent(By.xpath("//button[@disabled]"))) {

        }
        return true;

    }

    public boolean isErrorTextPresent() {
        if (isElementPresent(By.xpath("//div[@class='ng-star-inserted']"))) {

        }
        return true;
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(1000);
    }


    public void openRegistrationForm() {

        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));


        // JavascriptExecutor js = (JavascriptExecutor) wd;
        //js.executeScript("document.querySelector('#terms-of-use').click();");
        //js.executeScript("document.querySelector('#terms-of-use').checked=true;");


    }


    public boolean isErrorMassagePresent1() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(1)"))) {

        }
        return true;
    }

    public boolean isErrorMassagePresent2() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(2)"))) {

        }
        return true;
    }

    public void ReturnToTheMainPage() {
        click(By.xpath("//div[@class='header']//a[@class='logo']"));
    }

    public boolean isMassageErrorPresent1() {
        if (isElementPresent(By.cssSelector("div[class='error'] div:nth-child(1)"))) {

        }
        return true;
    }

    public boolean isMassageErrorPresent2() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(2)"))) {

        }
        return true;
    }

    public void checkPolicy() {

        //  js.executeScript("document.querySelector('#terms-of-use').click();");
        // js.executeScript("document.querySelector('#terms-of-use').checked=true;");
        // click(By.id("email"));
        Actions actions = new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector(".checkbox-container"));
        Rectangle rect = container.getRect();
        int x = rect.getX() + rect.getWidth() / 10;
        //int x = rect.getX() + 5;

        int y = rect.getY() + (1 / 4 * rect.getHeight());

        actions.moveByOffset(x, y).click().perform();
    }

    public boolean isSubmitFormPresent() {
        if (isElementPresent(By.cssSelector("[type='submit']"))) {

        }
        return true;
    }

    public void authorizationErrorOk() {
        click(By.cssSelector("button[type='button']"));
    }
}


