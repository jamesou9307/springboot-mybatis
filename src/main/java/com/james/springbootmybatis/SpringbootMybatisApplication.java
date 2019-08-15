package com.james.springbootmybatis;

import com.alibaba.fastjson.JSONObject;
import com.james.springbootmybatis.mapper.CityMapper;
import com.james.springbootmybatis.model.City;
import com.james.springbootmybatis.service.CityService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
@MapperScan(basePackages ={"com.james.springbootmybatis.mapper"})
public class SpringbootMybatisApplication
        implements CommandLineRunner {

    @Resource
    private CityMapper cityMapper;

    @Autowired
    private CityService cityService;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) {
        cityMapper.selectAll();
    }

    @RequestMapping("/city/list")
    public String selectAllCity(){

        List<City> cityList=cityService.selectAll();
        return JSONObject.toJSONString(cityList);
    }

    @RequestMapping("/city/{id}")
    public String selectCity(@PathVariable Long id){

        City city=cityService.selectCityById(id);
        return JSONObject.toJSONString(city);
    }

}
