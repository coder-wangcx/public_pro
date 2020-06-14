package com.team.house_backapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.mapper.HouseMapper;
import com.team.house_backapi.service.HouseService;
import com.team.house_backapi.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
      return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUserId(Integer id, PageParmeter parmeter) {
        // 开启分页
        PageHelper.startPage(parmeter.getPage(),parmeter.getPageSize());
        //查询当前userid下所有的信息
        List<House> list = houseMapper.selectAllById(id);
        return new PageInfo<House>(list);
    }

    @Override
    public int delHouseById(String id) {
        House house = new House();
        house.setId(id);
        house.setIsdel(1);  //设置isdel的值 改变状态值为1
        int i = houseMapper.updateByPrimaryKeySelective(house);
        return i;
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list=this.houseMapper.browserHouse(houseCondition);
        return new PageInfo<House>(list);
    }
}
