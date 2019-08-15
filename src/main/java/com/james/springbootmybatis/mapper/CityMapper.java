package com.james.springbootmybatis.mapper;

import com.james.springbootmybatis.model.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CityMapper {

    List<City> selectAll();

    City selectCityById(Long id);
}
