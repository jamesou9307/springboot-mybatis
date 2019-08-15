package com.james.springbootmybatis.service;

import com.james.springbootmybatis.model.City;

import java.util.List;

public interface CityService {
    List<City> selectAll();
    City selectCityById(Long id);
}
