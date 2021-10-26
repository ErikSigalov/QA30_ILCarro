package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath(("//a[@class='navigation-link'][normalize-space()='Log in'])[1]")));
    }


    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {

        click(By.xpath("//button[contains(text(),'Y’alla!')]"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("(//a[@class='navigation-link'][normalize-space()='Sign up'])[1]"));

    }

    public void logout() {

        click(By.xpath("(//a[@class='navigation-link'][normalize-space()='Sign up'])[1]"));
    }
}
