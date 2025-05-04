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
}
