package com.james.springbootmybatis.service.impl;

import com.james.springbootmybatis.mapper.CityMapper;
import com.james.springbootmybatis.model.City;
import com.james.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public List<City> selectAll() {
        return cityMapper.selectAll();
    }

    @Override
    public City selectCityById(Long id) {
        return cityMapper.selectCityById(id);
    }
}
