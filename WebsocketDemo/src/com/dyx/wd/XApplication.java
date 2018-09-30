package com.dyx.wd;

import com.dyx.wd.constants.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.Logger;

/**
 * @ProjectName: WebsocketDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-9-20 下午2:32
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class XApplication {
    public static void main(String[] args) {
        EventLoopGroup bossElp = new NioEventLoopGroup();
        EventLoopGroup workElp = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(bossElp, workElp);
            sb.channel(NioServerSocketChannel.class);
            sb.childHandler(new WebsocketChannelHandler());
            printInfo("服务器开启成功！");
            Channel channel = sb.bind(Constants.WEBSOCKET_PORT).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossElp.shutdownGracefully();
            workElp.shutdownGracefully();
        }
    }

    private static void printInfo(String s) {
        System.out.println(s);
    }
}
