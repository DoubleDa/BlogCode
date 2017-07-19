package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午2:44
 * alter person：dayongxin
 * alter time：2017/7/19 下午2:44
 * alter remark：
 */
public class AppleComputer extends Computer {

    protected AppleComputer() {
    }

    @Override
    public void setMemorySize(int memorySize) {
        mMemorySize = memorySize;
    }

    @Override
    public void setCoreSize(int coreSize) {
        mCoreSize = coreSize;
    }

    @Override
    public void setOsName(String osName) {
        mOsName = osName;
    }

    @Override
    public void setScreenSize(double screenSize) {
        mScreenSize = screenSize;
    }

    @Override
    public void setMainBoardName(String mainBoardName) {
        mMainBoardName = mainBoardName;
    }

    @Override
    public void setNeedSSD(boolean needSSD) {
        mIsNeedSSD = needSSD;
    }
}
