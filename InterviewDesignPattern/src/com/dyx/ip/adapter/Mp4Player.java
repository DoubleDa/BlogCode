package com.dyx.ip.adapter;

public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4Player：" + fileName);
    }

    @Override
    public void playRmvb(String fileName) {

    }

    @Override
    public void playMkv(String fileName) {

    }
}
