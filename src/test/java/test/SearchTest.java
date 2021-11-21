package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTest(){
        app.Search().fillSearchForm("Haifa","12/25/2021","12/26/2021");

        app.getUserHelper().submitForm();
        //Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }
}
