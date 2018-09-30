package com.dyx.wd;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ProjectName: WebsocketDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-9-20 下午2:28
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class WebsocketChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //http-codec
        socketChannel.pipeline().addLast("http-codec", new HttpServerCodec());
        //aggregator
        socketChannel.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        //http-chunked
        socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        //handler
        socketChannel.pipeline().addLast("handler", new WebsocketHandler());
    }
}
