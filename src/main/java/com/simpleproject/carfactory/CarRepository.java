package com.simpleproject.carfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Car> getAll() {
        return jdbcTemplate.query("SELECT * FROM cars",
                BeanPropertyRowMapper.newInstance(Car.class));
    }

    public Car getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE " + "id = ?",
                BeanPropertyRowMapper.newInstance(Car.class), id);
    }

    public int add(List<Car> cars) {
        cars.forEach(car -> jdbcTemplate
                .update("INSERT INTO cars(brand, model, year) VALUES (?,?,?)"
                ,car.getBrand(),car.getModel(),car.getYear()
                ));

        return 1;
    }

    public int update(Car car) {
        return jdbcTemplate.update("UPDATE cars SET brand=?, model=?, year=? WHERE id=?",
                car.getBrand(),car.getModel(),car.getYear(),car.getId());
    }
}
