package com.team.house_backapi;

import com.team.house_backapi.entity.DistrictExample;
import com.team.house_backapi.entity.Type;
import com.team.house_backapi.entity.Users;
import com.team.house_backapi.mapper.DistrictMapper;
import com.team.house_backapi.service.TypeService;
import com.team.house_backapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseBackapiApplicationTests {
    @Autowired(required=false)
    private DistrictMapper districtMapper;
    @Autowired(required=false)
    private UserService userService;
    @Autowired(required = false)
    private TypeService typeService;

    @Test
    public void contextLoads() {
        System.out.println("测试:"+districtMapper.selectByExample(new DistrictExample()).size());
    }
    @Test
    public void loginTest(){
        Users admin = userService.login("wangjianbing", "123456");
        System.out.println(admin.getId());
    }
    @Test
    public void getType(){
        List<Type> type = typeService.getType();
        for (Type type1:type) {
            System.out.println(type1.getId());
        }

    }
}
