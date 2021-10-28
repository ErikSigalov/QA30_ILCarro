package test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().logout();
        }
    }
    @Test
    public void test(){

        String email = "eriknet2010@mail.ru";
        String password = "Erik12345$";


        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitForm();


        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }
}
