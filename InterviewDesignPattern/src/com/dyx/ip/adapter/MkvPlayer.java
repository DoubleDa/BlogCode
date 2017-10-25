package com.dyx.ip.adapter;

public class MkvPlayer implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playRmvb(String fileName) {

    }

    @Override
    public void playMkv(String fileName) {
        System.out.println("MkvPlayer：" + fileName);
    }
}
