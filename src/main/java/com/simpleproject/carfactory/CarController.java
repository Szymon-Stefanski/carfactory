package com.simpleproject.carfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carRepository.getAll();
    }
}
