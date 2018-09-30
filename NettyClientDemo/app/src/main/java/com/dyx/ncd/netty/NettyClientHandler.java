package com.dyx.ncd.netty;

import android.util.Log;

import com.orhanobut.logger.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = NettyClientHandler.class.getName();
    private ByteBuf firstMessage;

    public NettyClientHandler() {
        byte[] req = "This message from client.".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bb = (ByteBuf) msg;
        byte[] req = new byte[bb.readableBytes()];
        bb.readBytes(req);

        String body = new String(req, "UTF-8");
        Logger.d("The Server Response is:" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
