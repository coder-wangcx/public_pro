package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Street;
import com.team.house_backapi.service.StreetService;
import com.team.house_backapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street/")
public class StreetController {
    @Autowired(required = false)
    private StreetService streetService;
    @RequestMapping("getStreetData")
    public BaseResult getStreetDate(Integer did){
        List<Street> streets = streetService.getStreetByDid(did);
        return new BaseResult(200,streets);
    }

}
