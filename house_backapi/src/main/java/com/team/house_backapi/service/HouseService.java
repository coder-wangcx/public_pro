package com.team.house_backapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.utils.PageParmeter;


public interface HouseService {
    //发布出租房
    public int addHouse(House house);

    /**
     * 查询某用户下的出租房
     * @param userid  用户编号
     * @param pageParmeter  分页的参数，页码，页大小
     * @return
     */
    public PageInfo<House> getHouseByUserId(Integer userid, PageParmeter pageParmeter);

    //逻辑删除 ->修改house表中的isdel的值（改变状态）
    public int delHouseById(String id);

    /**
     * 搜索浏览出租房
     * @param houseCondition  搜索条件
     * @return 返回搜索的出租房
     */

    public PageInfo<House>  getBroswerHouse(HouseCondition houseCondition);


}
