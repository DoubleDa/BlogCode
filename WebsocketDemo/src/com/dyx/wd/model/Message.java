package com.dyx.wd.model;

/**
 * @ProjectName: WebsocketDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-9-20 下午4:36
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Message {
    private String content;
    private String time;
    private String channelId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
