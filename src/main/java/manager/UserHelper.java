package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        WebElement submit= wd.findElement(By.cssSelector("button[type='submit']"));
        new WebDriverWait(wd,10)
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

    WebDriverWait wait = new WebDriverWait(wd,10);
    wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

    return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
}

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")));
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isErrorMessageWrongFormat() {
        if(isElementPresent(By.xpath("//h2[normalize-space()='Wrong email or password']"))){

        }return true;
    }

    public boolean isButtonPresent() {
        if(isElementPresent(By.xpath("//button[@disabled]"))) {

        }return true;

    }

    public boolean isErrorTextPresent() {
        if(isElementPresent(By.xpath("//div[@class='ng-star-inserted']"))){

        }return true;
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
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastname());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));


       // JavascriptExecutor js = (JavascriptExecutor) wd;
        //js.executeScript("document.querySelector('#terms-of-use').click();");
        //js.executeScript("document.querySelector('#terms-of-use').checked=true;");


    }


    public boolean isErrorMassagePresent1() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(1)"))){

        }return true;
    }
    public boolean isErrorMassagePresent2() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(2)"))){

        }return true;
    }

    public void ReturnToTheMainPage() {
        click(By.xpath("//div[@class='header']//a[@class='logo']"));
    }

    public boolean isMassageErrorPresent1() {
        if (isElementPresent(By.cssSelector("div[class='error'] div:nth-child(1)"))){

        }return true;
    }
    public boolean isMassageErrorPresent2() {
        if (isElementPresent(By.cssSelector("div[class='input-container'] div:nth-child(2)"))){

        }return true;
    }
}


