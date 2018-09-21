package com.apex.carapp.services;

import com.apex.carapp.entities.CarPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    @Autowired
    CarService carService;

    @PostMapping("/addCarPart")
    public Long addCarPart(@ModelAttribute("car") CarPart carPart) throws Exception {
        return carService.addCarPart(carPart);
    }

    @DeleteMapping("/removeCarPart")
    public CarPart removeCarPart(@RequestParam("partId") long partId) throws Exception {
        return carService.removePart(partId);
    }

    @GetMapping("/searchByPartId")
    public CarPart search(@RequestParam("partId") long partId) throws Exception {
        return carService.search(partId);
    }

    @GetMapping("/search")
    public List<CarPart> search(@RequestParam(name = "model", required = false) String model,
                                @RequestParam(name = "make", required = false) String make,
                                @RequestParam(name = "year", required = false) String year) throws Exception {
        return carService.search(model, make, year);
    }
}
