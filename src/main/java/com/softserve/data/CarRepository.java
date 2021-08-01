package com.softserve.data;

import java.util.List;
import java.util.Map;

import com.softserve.entity.Car1;
import com.softserve.utils.FileUtil;

public final class CarRepository {
    private static volatile CarRepository instance = null;
    //
    private CarRepository() {
    }

    public static CarRepository get() {
        if (instance == null) {
            synchronized (CarRepository.class) {
                if (instance == null) {
                    instance = new CarRepository();
                }
            }
        }
        return instance;
    }

    public String getDefault() {
        return System.getenv("USER_EMAIL");
    }
    
    public Map<String, Car1> getCarsMap(){
        return new FileUtil().getCarsMap();
    }
    
    public List<Car1> getListOfCars(){
        return new FileUtil().getListOfCars();
    }

}
