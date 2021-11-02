package test;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest1 extends TestBase {
    //is logged  ---- precondition
    //open form
    //fill form + mode; car
    //attach photo
    //submit form

    @BeforeMethod

    public void preCondition() {

    if (app.getUserHelper().isLogged()){
        app.getUserHelper().login(new User().withEmail("eriknet2010@mail.ru").withPassword("Erik12345$"));
    }
    }

    @Test
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
         app.getCar().attachedPhoto1();
         app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isAddSuccess());
    }


}
