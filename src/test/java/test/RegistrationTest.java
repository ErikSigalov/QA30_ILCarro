package test;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test(dataProvider = "registrationCSV",dataProviderClass = MyDataProvider.class)
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Eril").withLastname("Snows")
                .withEmail("snow" + i + "@gmail.com")
                .withPassword("Snow12345!");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        logger.info("Test Registration Positive starts with >>>" + user.getEmail() + " &&&& " + user.getPassword());

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        //app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getCar().isRegistered());
        app.getUserHelper().clickOkButton();
        app.getUserHelper().logout();

    }
    @Test
    public void registrationWrongPassword() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Er").withLastname("Snow")
                .withEmail("smow" + i + "@gmail.com")
                .withPassword("Sno");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        //app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isErrorMassagePresent1());
        Assert.assertTrue(app.getUserHelper().isErrorMassagePresent2());
        app.getUserHelper().ReturnToTheMainPage();

    }
    @Test
    public void registrationWrongEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Er").withLastname("Snow")
                .withEmail("smow" + i + "gmail.com")
                .withPassword("Snow12345!");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        //app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isMassageErrorPresent1());
        Assert.assertTrue(app.getUserHelper().isMassageErrorPresent2());
        app.getUserHelper().ReturnToTheMainPage();
    }

        @AfterMethod
        public void postCondition(){

        //app.getUserHelper().clickOkButton();

    }



}

