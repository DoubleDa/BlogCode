package com.dyx.nsd.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.logging.Logger;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = "NettyServerHandler";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bb = (ByteBuf) msg;
        byte[] req = new byte[bb.readableBytes()];
        bb.readBytes(req);
        String body = new String(req, "UTF-8");
        Logger logger = Logger.getLogger(TAG);
        logger.info("The time server receive order:" + body);
        String currentTime = "Query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad Order";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
