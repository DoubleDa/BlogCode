package com.dyx.ip.adapter;

/**
 * 适配器类
 */
public class MediaAdapter implements MediaPlayer {
    private AdvanceMediaPlayer mAdvanceMediaPlayer;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase(Constants.TYPE_MP4)) {
            mAdvanceMediaPlayer = new Mp4Player();
        } else if (type.equalsIgnoreCase(Constants.TYPE_RMVB)) {
            mAdvanceMediaPlayer = new RmvbPlayer();
        } else if (type.equalsIgnoreCase(Constants.TYPE_MKV)) {
            mAdvanceMediaPlayer = new MkvPlayer();
        }
    }

    @Override
    public void play(String type, String fileName) {
        if (type.equalsIgnoreCase(Constants.TYPE_MP4)) {
            mAdvanceMediaPlayer.playMp4(fileName);
        } else if (type.equalsIgnoreCase(Constants.TYPE_RMVB)) {
            mAdvanceMediaPlayer.playRmvb(fileName);
        } else if (type.equalsIgnoreCase(Constants.TYPE_MKV)) {
            mAdvanceMediaPlayer.playMkv(fileName);
        }
    }
}
