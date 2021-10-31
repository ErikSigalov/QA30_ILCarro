package models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Car {
    private String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;

    String gear;
    String wD;

    String doors;
    String seats;
    String clasS;

    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceInclude;
    String typeFeature;
    String about;


}
