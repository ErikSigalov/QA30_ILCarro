package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getUserHelper().isLogged()){
            app.getUserHelper().logout();
        }
    }
    @Test
    public void test(){

        String email = "eriknet2010@mail.ru";
        String password = "Erik12345$";


        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(email, password);
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(5000);

        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUserHelper().isLogged());
    }
}
