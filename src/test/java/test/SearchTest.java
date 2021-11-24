package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTest(){
        app.Search().fillSearchForm("Haifa","12/25/2021","12/26/2021");

        app.getUserHelper().submitForm();
        Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }
    @Test
    public void searchTest2(){
        app.Search().fillSearchForm("Haifa","11/30/2021","12/12/2021");

        app.getUserHelper().submitForm();
        Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }
    @Test
    public void searchTestYear(){
        app.Search().fillInputCity("Haifa");
        app.Search().selectPeriodNew("12/25/2021","02/27/2022");
        app.Search().pause(5000);
    }
    @AfterMethod
    public void post(){

        app.Search().returnToMainPage();
    }

}
