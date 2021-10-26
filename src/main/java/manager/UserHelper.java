package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath(("//a[@class='navigation-link'][normalize-space()='Log in']")));
    }


    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {

        click(By.xpath("//button[1]"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()=' Sign up ']"));

    }

    public void logout() {

        click(By.xpath("//button[text()=' Sign up ']"));
    }
}
