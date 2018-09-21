package com.apex.carapp.services;

import com.apex.carapp.entities.CarPart;
import com.apex.carapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    public Long addCarPart(CarPart carPart) throws Exception {
        CarPart carPartSaved = carRepository.save(carPart);
        return carPartSaved.getPartId();
    }

    public CarPart removePart(long partId) throws Exception {
        CarPart carPart = carRepository.findById(partId).get();
        carRepository.delete(carPart);
        return carPart;
    }

    public CarPart search(long partId) throws Exception {
        return carRepository.findById(partId).get();
    }

    public List<CarPart> search(String make, String model, String year) throws Exception {
        CarPart carPart = new CarPart(0, make, model, year);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("partId")
                .withIncludeNullValues()
                .withIgnoreCase();
        return carRepository.findAll(Example.of(carPart, matcher));
    }

}
