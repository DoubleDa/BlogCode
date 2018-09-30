package com.dyx.wacd.model;

public class MsgModel {
    private String time;
    private String channelId;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgModel{" +
                "time='" + time + '\'' +
                ", channelId='" + channelId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
