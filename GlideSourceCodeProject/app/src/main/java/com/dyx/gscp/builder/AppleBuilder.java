package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午2:53
 * alter person：dayongxin
 * alter time：2017/7/19 下午2:53
 * alter remark：
 */
public class AppleBuilder extends Builder {
    private Computer computer = new AppleComputer();

    @Override
    public void buildMemorySize(int memorySize) {
        computer.setMemorySize(memorySize);
    }

    @Override
    public void buildCoreSize(int coreSize) {
        computer.setCoreSize(coreSize);
    }

    @Override
    public void buildOsName(String osName) {
        computer.setOsName(osName);
    }

    @Override
    public void buildScreenSize(double screenSize) {
        computer.setScreenSize(screenSize);
    }

    @Override
    public void buildMainBoardName(String mainBoardName) {
        computer.setMainBoardName(mainBoardName);
    }

    @Override
    public void buildIsNeedSSD(boolean isNeedSSD) {
        computer.setNeedSSD(isNeedSSD);
    }

    @Override
    public Computer create() {
        return computer;
    }
}
