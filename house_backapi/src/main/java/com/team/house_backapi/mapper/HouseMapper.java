package com.team.house_backapi.mapper;

import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //根据userid 查询房子信息
    List<House> selectAllById(Integer id);

    //浏览出租房
    List<House> browserHouse(HouseCondition houseCondition);

    //根据houseId查询单条然后修改
    House getHouseByID(String id);

}