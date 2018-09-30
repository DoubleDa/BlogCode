package com.dyx.ncd.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public void bind(String address, int port) {
        //配置客户端的NIO线程组
        EventLoopGroup elp = new NioEventLoopGroup();
        //
        Bootstrap b = new Bootstrap();
        //
        b.group(elp).
                channel(NioSocketChannel.class).
                option(ChannelOption.TCP_NODELAY, true).
                handler(new ChildChannelHandler());
        try {
            //发生异步连接操作
            ChannelFuture cf = b.connect(address, port).sync();
            //等待客户端链路关闭
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            elp.shutdownGracefully();
        }
    }
}
