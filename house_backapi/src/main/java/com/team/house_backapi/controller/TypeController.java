package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Type;
import com.team.house_backapi.service.TypeService;
import com.team.house_backapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired(required = false)
    private TypeService typeService;
    @RequestMapping("/getType")
    public BaseResult getType(){
        List<Type> typeList = typeService.getType();
        BaseResult result = new BaseResult(200, typeList);
        return result;
    }

}
