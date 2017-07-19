package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：Computer产品抽象类
 * create person：dayongxin
 * create time：2017/7/19 下午2:38
 * alter person：dayongxin
 * alter time：2017/7/19 下午2:38
 * alter remark：
 */
public abstract class Computer {
    //内存
    protected int mMemorySize = 0;
    //核心数
    protected int mCoreSize = 0;
    //操作系统
    protected String mOsName = "windows";
    //显示器
    protected double mScreenSize = 0;
    //主板生产商
    protected String mMainBoardName = "dell";
    //是否需要固态硬盘
    protected boolean mIsNeedSSD = false;

    protected Computer() {
    }

    public abstract void setMemorySize(int memorySize);

    public abstract void setCoreSize(int coreSize);

    public abstract void setOsName(String osName);

    public abstract void setScreenSize(double screenSize);

    public abstract void setMainBoardName(String mainBoardName);

    public abstract void setNeedSSD(boolean needSSD);

    @Override
    public String toString() {
        return "Computer{" +
                "mMemorySize=" + mMemorySize +
                ", mCoreSize=" + mCoreSize +
                ", mOsName='" + mOsName + '\'' +
                ", mScreenSize=" + mScreenSize +
                ", mMainBoardName='" + mMainBoardName + '\'' +
                ", mIsNeedSSD=" + mIsNeedSSD +
                '}';
    }
}
