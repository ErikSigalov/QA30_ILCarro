package test;


import manager.MyDataProvider;
import manager.NgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners(NgListener.class)
public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().logout();
        }
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = MyDataProvider.class)
    public void test(User user) {
        //User user = new User().withEmail("eriknet2010@mail.ru").withPassword("Erik12345$");

        //System.out.println("email" + "&&" + "password");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();
        app.getUserHelper().clickOkButton();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }


    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
    public void test2(String email, String password) {

        //String email = "eriknet2010@mail.ru";
        //String password = "Erik12345$";
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitForm();
        app.getUserHelper().clickOkButton();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }

    @Test
    public void wrongEmailLogin() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("eriknet2010mail.ru", "Erik12345$");
        //app.getUserHelper().submitForm();

        //Assert.assertFalse(app.getUserHelper().isLoggedSuccess());
        Assert.assertTrue(app.getUserHelper().isSubmitFormPresent());
        Assert.assertTrue(app.getUserHelper().isErrorTextPresent());
        app.getUserHelper().ReturnToTheMainPage();
    }

    @Test
    public void wrongPasswordLogin() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("eriknet2010@mail.ru", "Erik12345");
        app.getUserHelper().submitForm();
        app.getUserHelper().authorizationErrorOk();

        //Assert.assertFalse(app.getUserHelper().isLoggedSuccess());

        Assert.assertTrue(app.getUserHelper().isSubmitFormPresent());
        Assert.assertTrue(app.getUserHelper().isErrorMessageWrongFormat());
        app.getUserHelper().ReturnToTheMainPage();
    }

    @Test
    public void notRegisteredUser() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("eriknet@201mail.ru", "Erik88345$");
        app.getUserHelper().submitForm();

        Assert.assertFalse(app.getUserHelper().isLoggedSuccess());
    }

    @AfterMethod
    public void postCondition() {

        //app.getUserHelper().clickOkButton();
    }
}
