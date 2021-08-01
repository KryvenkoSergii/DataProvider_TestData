package com.softserve;

import java.util.List;
import java.util.Map;

import com.softserve.data.CarRepository;
import com.softserve.entity.Car1;
import com.softserve.utils.FileUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        FileUtil fileUtil = new FileUtil();
        List<Car1> carsList = fileUtil.getListOfCars();
        
//        carsList.forEach(System.out::println);
        
        Map<String, Car1> cars = CarRepository.get().getCarsMap();
        
        cars.entrySet().stream().forEach(e-> System.out.println(e));

    }
}
