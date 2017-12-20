# Android Live Stream System

## Video Capture Source


## Live Stream Server

Use SRS:

- download srs source codes

```java
git clone https://git.oschina.net/winlinvip/srs.oschina.git
```

- build SRS

```java
cd trunk
```

```java
./configure --osx --without-ssl --without-hls --without-hds --without-dvr --without-nginx --without-http-callback --without-http-server --without-stream-caster --without-http-api --without-ffmpeg --without-transcode --without-ingest --without-stat --without-librtmp
```

```java
make
```

## Live Stream Player


## Reference

- [如何在网页端和移动端播放rtmp和hls视频流](https://medium.com/@459631839/%E5%A6%82%E4%BD%95%E5%9C%A8%E7%BD%91%E9%A1%B5%E7%AB%AF%E5%92%8C%E7%A7%BB%E5%8A%A8%E7%AB%AF%E6%92%AD%E6%94%BErtmp%E5%92%8Chls%E8%A7%86%E9%A2%91%E6%B5%81-e651695bf980)
- [Android使用FFMpeg实现推送视频直播流到服务器](https://www.cnblogs.com/android-blogs/p/5816912.html)
- [SRS](https://github.com/ossrs/srs)