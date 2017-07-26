package com.dyx.td.model;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/1 下午3:44
 * alter person：dayongxin
 * alter time：2017/7/1 下午3:44
 * alter remark：
 */
public class PatchInfoModel {
    private String patchUrl;
    private String patchVersion;
    private String md5Value;

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public void setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }
}
