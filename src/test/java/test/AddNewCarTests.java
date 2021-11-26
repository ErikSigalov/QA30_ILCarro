package test;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    //is logged  ---- precondition
    //open form
    //fill form + mode; car
    //attach photo
    //submit form

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
if(app.getUserHelper().isLogged()){
    app.getUserHelper().login(new User().withEmail(app.email()).withPassword(app.password()));
}
    }

    @Test(invocationCount = 1,groups = {"web","smoke"})
    public void addNewTestPositive(){
    int i = (int)((System.currentTimeMillis()/1000)%3600);

    Car car = Car.builder()
            .address("Tel Aviv")
            .make("BMW")
            .model("M5")
            .year("2020")
            .engine("2.3")
            .fuel("Hybrid")
            .gear("MT")
            .wD("AWD")
            .doors("5")
            .seats("4")
            .clasS("C")
            .fuelConsumption("6.5")
            .carRegNumber("100-55-"+i)
            .price("65")
            .distanceInclude("500")
            .typeFeature("type of")
            .about("Very nice car")
            .build();
    app.getCar().openCarForm();
    app.getCar().fillCarForm(car);
    app.getCar().attachedPhoto("C:\\Erik QA 30\\auto.jpeg");
    app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());

    }
    @Test(groups = {"web"})
    public void addNewTestPositive1(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Toronto")
                .make("Nissan")
                .model("Juke")
                .year("2021")
                .engine("1.6")
                .fuel("Electric")
                .gear("AT")
                .wD("AWD")
                .doors("3")
                .seats("5")
                .clasS("B")
                .fuelConsumption("9")
                .carRegNumber("55-654-36"+i)
                .price("560")
                .distanceInclude("500")
                .typeFeature("Road off")
                .about("Very Special car")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto("C:\\Erik QA 30\\auto.jpeg");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(){
       app.getCar().submitAddedCar();
        app.getUserHelper().logout();
    }
}
