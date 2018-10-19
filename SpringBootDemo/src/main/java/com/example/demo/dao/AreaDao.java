package com.example.demo.dao;

import com.example.demo.model.Area;

import java.util.List;

/**
 * @ProjectName: SpringBootDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-10-19 下午3:45
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface AreaDao {
    //获取区域列表
    List<Area> queryArea();

    //通过区域Id获取区域信息
    Area getAreaById(int areaId);

    //增加区域信息
    int addArea(Area area);

    //修改区域信息
    int alterArea(Area area);

    //删除区域信息
    int deleteAreaById(int areaId);
}
