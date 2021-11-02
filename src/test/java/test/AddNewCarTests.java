package test;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    //is logged  ---- precondition
    //open form
    //fill form + mode; car
    //attach photo
    //submit form

    @BeforeMethod
    public void precondition(){
if(app.getUserHelper().isLogged()){
    app.getUserHelper().login(new User().withEmail("eriknet2010@mail.ru").withPassword("Erik12345$"));
}
    }

    @Test
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
    app.getCar().attachedPhoto();
    app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isAddSuccess());

    }
}
