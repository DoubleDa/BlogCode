package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午2:48
 * alter person：dayongxin
 * alter time：2017/7/19 下午2:48
 * alter remark：
 */
public abstract class Builder {
    //内存
    public abstract void buildMemorySize(int memorySize);

    //核心数
    public abstract void buildCoreSize(int coreSize);

    //操作系统
    public abstract void buildOsName(String osName);

    //显示器
    public abstract void buildScreenSize(double screenSize);

    //主板生产商
    public abstract void buildMainBoardName(String mainBoardName);

    //是否需要固态硬盘
    public abstract void buildIsNeedSSD(boolean isNeedSSD);

    //构建Computer

    public abstract Computer create();
}
