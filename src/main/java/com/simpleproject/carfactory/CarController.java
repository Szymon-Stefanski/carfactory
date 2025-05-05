package com.simpleproject.carfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Car> cars) {
        return carRepository.add(cars);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Car updatedCar) {
        Car car = carRepository.getById(id);

        if (car != null) {
            car.setBrand(updatedCar.getBrand());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());

            carRepository.update(car);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Car updatedCar) {
        Car car = carRepository.getById(id);

        if (car != null) {
            car.setBrand(updatedCar.getBrand());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());

            carRepository.update(car);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return carRepository.delete(id);
    }
}
