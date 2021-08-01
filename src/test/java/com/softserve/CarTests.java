package com.softserve;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.softserve.data.DataProviderClass;
import com.softserve.entity.Car;

public class CarTests extends DataProviderClass {
    
    @Test(dataProvider = "getCarsMap")
    public void outputMapToConsole(final String key, final Car value) {
        System.out.println("Map key = " + key + "; Map value = " + value);
        assertTrue( true );
    }
    
    @Test(dataProvider = "getCarsData")
    public void outputCarDataForEachJsonCarObject(final Car car) {
        System.out.println(car);
        assertTrue( true );
    }
    
    @Test(dataProvider = "getExtractedListOfCars")
    public void outputListOfCars(final Car... cars) {
        Arrays.stream(cars).forEach(System.out::println);
        assertTrue( true );
    }
    
    @Test(dataProvider = "getCarsFromJson")
    public void outputStreamUsers(final Car car) {
        System.out.println(car);
        assertTrue( true );
    }

}
