package com.example.demo.controller;

import com.example.demo.constants.FieldConstants;
import com.example.demo.model.Area;
import com.example.demo.service.AreaService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: SpringBootDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-10-19 下午3:39
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService mAreaService;

    @RequestMapping(value = "/getAreaList", method = RequestMethod.GET)
    private Map<String, Object> getAreaList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Area> areaList = new ArrayList<>();
        areaList.addAll(mAreaService.getAreaList());
        map.put(FieldConstants.AREA_LIST, areaList);
        return map;
    }

    @RequestMapping(value = "/getAreaById", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Area area = mAreaService.getAreaById(areaId);
        map.put(FieldConstants.AREA, area);
        return map;
    }

    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    public Map<String, Object> addArea(@RequestBody Area area) throws
            JsonParseException,
            JsonMappingException,
            IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(FieldConstants.SUCCESS, mAreaService.addArea(area));
        return map;
    }

    @RequestMapping(value = "/alterArea", method = RequestMethod.POST)
    public Map<String, Object> alterArea(@RequestBody Area area) throws
            JsonParseException,
            JsonMappingException,
            IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(FieldConstants.SUCCESS, mAreaService.alterArea(area));
        return map;
    }

    @RequestMapping(value = "/deleteAreaById", method = RequestMethod.GET)
    public Map<String, Object> deleteAreaById(Integer areaId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(FieldConstants.SUCCESS, mAreaService.deleteAreaById(areaId));
        return map;
    }
}
