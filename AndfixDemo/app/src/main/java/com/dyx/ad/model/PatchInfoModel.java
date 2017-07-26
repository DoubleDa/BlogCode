package com.dyx.ad.model;

import java.io.Serializable;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 下午1:46
 * alter person：dayongxin
 * alter time：2017/6/30 下午1:46
 * alter remark：
 */
public class PatchInfoModel implements Serializable {
    private String patchUrl;
    private String patchVersion;

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
