package com.softserve.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.softserve.entity.Car1;

public class FileUtil {

    private Properties properties;
    private final String PROPERTIES_PATH = "src\\test\\resources\\project.properties";

    public FileUtil() {
        properties = new Properties();
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCarsFilePath() {
        return properties.getProperty("cars.filepath");
    }

    @SuppressWarnings("unchecked")
    public List<Car1> getListOfCars() {
        List<Car1> carsList = new ArrayList<Car1>();

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(getCarsFilePath())) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray carsL = (JSONArray) obj;
//            System.out.println(carsL);

            // Iterate over employee array
//            carsL.forEach( cars -> parseCarObject( (JSONObject) cars ) );
            carsL.forEach(cars -> {
                carsList.add(parseCarObject((JSONObject) cars));
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return carsList;
    }

    public Map<String, Car1> getCarsMap() {
        List<Car1> carsList = getListOfCars();
        Map<String, Car1> carsMap = new HashMap<String, Car1>();
        carsList.forEach(cars -> {
            carsMap.put(cars.getBrand(), cars);
        });
        return carsMap;
    }

    private Car1 parseCarObject(JSONObject carObject) {
        Car1 car = new Car1();

        car.setBrand((String) carObject.get("brand"));
        car.setModel((String) carObject.get("model"));
        car.setYear(Integer.parseInt((String) carObject.get("year")));
        car.setFuelType((String) carObject.get("fuelType"));
        car.setTransmission(Integer.parseInt((String) carObject.get("transmission")));
        car.setHorsePower(Integer.parseInt((String) carObject.get("horsePower")));

        return car;
    }
}
