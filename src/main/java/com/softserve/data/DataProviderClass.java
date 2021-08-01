package com.softserve.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softserve.entity.Car;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import io.github.sskorol.data.TestDataReader;
import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;

public class DataProviderClass {

    private List<Car> carsList = TestDataReader.use(JsonReader.class).withTarget(Car.class).read().toList();

    /**
     * 1) Write a DataProvider which returns a Map<brand, Car>
     * @return Map<String, Car>
     */
    @DataSupplier(flatMap = true)
    public Map<String, Car> getCarsMap() {

        Map<String, Car> carsMap = new HashMap<String, Car>();
        carsList.forEach(c -> {
            carsMap.put(c.getBrand(), c);
        });
        return EntryStream.of(carsMap).toMap();
    }

    /**
     * 2) Write a DataProvider that will be called 3 times for each Car data
     * @return Car
     */
    @DataSupplier
    public StreamEx<Car> getCarsData() {
        return TestDataReader.use(JsonReader.class).withTarget(Car.class).read();
    }

    /**
     * 3) Write a DataProvider which returns 3 Car objects at that time
     * @return List<Car>
     */
    @DataSupplier(transpose = true)
    public List<Car> getExtractedListOfCars() {
        return carsList;
    }

    /**
     * 4) Write a DataProvider which read data from the cars.json file
     * @return StreamEx<Car>
     */
    @DataSupplier
    public StreamEx<Car> getCarsFromJson() {
        return TestDataReader.use(JsonReader.class).withTarget(Car.class).withSource("cars.json").read();
    }
}