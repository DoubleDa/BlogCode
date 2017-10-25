package com.dyx.ip.adapter;

public class RmvbPlayer implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playRmvb(String fileName) {
        System.out.println("RmvbPlayer：" + fileName);
    }

    @Override
    public void playMkv(String fileName) {

    }
}
