package com.example.demo.service;

import com.example.demo.model.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: SpringBootDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-10-19 下午3:40
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface AreaService {
    //获取区域列表
    List<Area> getAreaList();

    //通过区域Id获取区域信息
    Area getAreaById(int areaId);

    //增加区域信息
    boolean addArea(Area area);

    //修改区域信息
    boolean alterArea(Area area);

    //删除区域信息
    boolean deleteAreaById(int areaId);
}
