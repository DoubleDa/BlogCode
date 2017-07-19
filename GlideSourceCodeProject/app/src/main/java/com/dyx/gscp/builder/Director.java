package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午2:55
 * alter person：dayongxin
 * alter time：2017/7/19 下午2:55
 * alter remark：
 */
public class Director {
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void constructor(int memorySize,
                            int coreSize,
                            String osName,
                            double screenSize,
                            String mainBoardName,
                            boolean isNeedSSD) {
        builder.buildMemorySize(memorySize);
        builder.buildCoreSize(coreSize);
        builder.buildOsName(osName);
        builder.buildScreenSize(screenSize);
        builder.buildMainBoardName(mainBoardName);
        builder.buildIsNeedSSD(isNeedSSD);
    }
}
