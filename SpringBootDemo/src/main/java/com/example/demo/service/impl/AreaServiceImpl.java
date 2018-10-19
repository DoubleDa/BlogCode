package com.example.demo.service.impl;

import com.example.demo.constants.TextConstants;
import com.example.demo.dao.AreaDao;
import com.example.demo.model.Area;
import com.example.demo.service.AreaService;
import com.example.demo.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: SpringBootDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-10-19 下午3:44
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao mAreaDao;

    @Override
    public List<Area> getAreaList() {
        if (mAreaDao != null) {
            return mAreaDao.queryArea();
        }
        return null;
    }

    @Override
    public Area getAreaById(int areaId) {
        if (mAreaDao != null) {
            return mAreaDao.getAreaById(areaId);
        }
        return null;
    }

//    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (!TextUtils.isEmpty(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int num = mAreaDao.addArea(area);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException(TextConstants.EXCEPTION_AREA_ADD_FAILED);
                }
            } catch (Exception e) {
                throw new RuntimeException(TextConstants.EXCEPTION_AREA_ADD_FAILED_DETAIL + e.getMessage());
            }
        } else {
            throw new RuntimeException(TextConstants.EXCEPTION_AREA_NOT_NULL);
        }
    }

    @Transactional
    @Override
    public boolean alterArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int num = mAreaDao.alterArea(area);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException(TextConstants.EXCEPTION_AREA_ALTER_FAILED);
                }
            } catch (Exception e) {
                throw new RuntimeException(TextConstants.EXCEPTION_AREA_ALTER_FAILED_DETAIL + e.getMessage());
            }
        } else {
            throw new RuntimeException(TextConstants.EXCEPTION_AREA_NOT_NULL);
        }
    }

    @Override
    public boolean deleteAreaById(int areaId) {
        if (areaId > 0) {
            try {
                int num = mAreaDao.deleteAreaById(areaId);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException(TextConstants.EXCEPTION_AREA_ID_FAILED);
                }
            } catch (Exception e) {
                throw new RuntimeException(TextConstants.EXCEPTION_AREA_ID_FAILED_DETAIL + e.toString());
            }
        } else {
            throw new RuntimeException(TextConstants.EXCEPTION_AREA_ID_NOT_NULL);
        }
    }
}
