package com.dyx.ip.adapter;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mMediaAdapter;

    @Override
    public void play(String type, String fileName) {
        if (type.equalsIgnoreCase(Constants.TYPE_MP3)) {
            System.out.println("mp3 player：" + fileName);
        } else if (type.equalsIgnoreCase(Constants.TYPE_MP4) || type.equalsIgnoreCase(Constants.TYPE_RMVB) || type.equalsIgnoreCase(Constants.TYPE_MKV)) {
            mMediaAdapter = new MediaAdapter(type);
            mMediaAdapter.play(type, fileName);
        } else {
            System.out.println("No Support Type：" + type);
        }
    }
}
