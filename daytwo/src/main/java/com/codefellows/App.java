package com.codefellows;

import com.codefellows.Person.Builder;

public class App
{
    public static void main( String[] args )
    {
        OneBigElectronicDevice tv = new OneBigElectronicDevice("tv");
        OneBigElectronicDevice phone = new OneBigElectronicDevice("phone");
        OneBigElectronicDevice nestThermostat = new OneBigElectronicDevice("thermostat");

        tv.setChannel(5);

        if (phone.getCurrentApp() == null) {
            phone.setCurrentApp("facebook");
        }

        ElectronicDevice tv2 = new Television();
        ElectronicDevice phone2 = new MobilePhone();

//        if (tv2 instanceof Television) {
//            ((Television)tv2).turnOn(5);
//        }

        tv2.turnOn(5);
        tv2.turnOff();

        phone2.turnOn();
        phone2.turnOff();

        Person p = Person.builder()
                         .age(25)
                         .city("Seattle, WA")
                         .favoriteColor("Blue")
                         .name("Brad")
                         .build();

        Person.Builder pb = new Person.Builder();

//        Person p = new Person(25, "Brad", "Seattle", "Blue");
//        Person.Builder pb = new Person.Builder();

        WebClient wc = new WebClient(new MobileDeviceWebService());

        IComplexWebService.getNumberOfWebServices();
        System.out.println(IComplexWebService.MAX_NUM_SERVICES);
    }
}
