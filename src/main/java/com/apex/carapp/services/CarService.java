package com.apex.carapp.services;

import com.apex.carapp.entities.CarPart;

import java.util.List;

public interface CarService {

    Long addCarPart(CarPart carPart) throws Exception;

    CarPart removePart(long partId) throws Exception;

    CarPart search(long partId) throws Exception;

    List<CarPart> search(String make, String model, String year) throws Exception;

}


