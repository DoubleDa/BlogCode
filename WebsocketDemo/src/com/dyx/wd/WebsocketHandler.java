package com.dyx.wd;

import com.dyx.wd.constants.Constants;
import com.dyx.wd.model.Message;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.util.Date;
import java.util.logging.Logger;

/**
 * @ProjectName: WebsocketDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-9-20 下午2:00
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class WebsocketHandler extends SimpleChannelInboundHandler<Object> {
    private Logger logger = Logger.getLogger(getClass().getName());
    private WebSocketServerHandshaker handshaker;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.CHANNEL_GROUP.add(ctx.channel());
        logger.info("客户端与服务器端连接开启...");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.CHANNEL_GROUP.remove(ctx.channel());
        logger.info("客户端与服务器端连接关闭...");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if (o instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) o);
        } else if (o instanceof WebSocketFrame) {
            handleWebSocketFrame(channelHandlerContext, (WebSocketFrame) o);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext chx, WebSocketFrame frame) {
        //CloseWebSocketFrame
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(chx.channel(), (CloseWebSocketFrame) frame.retain());
        }
        //PingWebSocketFrame
        if (frame instanceof PingWebSocketFrame) {
            chx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        //TextWebSocketFrame
        if (!(frame instanceof TextWebSocketFrame)) {
            logger.info("目前不支持二进制...");
            throw new RuntimeException("【"+this.getClass().getName()+"】不支持消息");
        }
        String request = ((TextWebSocketFrame) frame).text();
        logger.info("服务器收到客户端消息为:" + request);
        TextWebSocketFrame webSocketFrame = new TextWebSocketFrame(getTime() + "|" + chx.channel().id() + "|" + request);
        NettyConfig.CHANNEL_GROUP.writeAndFlush(webSocketFrame);
    }

    private String getTime() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private void handleHttpRequest(ChannelHandlerContext context, FullHttpRequest request) {
        if (!request.getDecoderResult().isSuccess() || !("websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(context, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(Constants.WEBSOCKET_URL, null, false);
        handshaker = factory.newHandshaker(request);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(context.channel());
        } else {
            handshaker.handshake(context.channel(), request);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext context, FullHttpRequest request, DefaultFullHttpResponse defaultFullHttpResponse) {
        if (defaultFullHttpResponse.getStatus().code() != 200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(defaultFullHttpResponse.getStatus().toString(), CharsetUtil.UTF_8);
            defaultFullHttpResponse.content().writeBytes(byteBuf);
            byteBuf.release();
        }
        ChannelFuture future = context.channel().writeAndFlush(defaultFullHttpResponse);
        if (defaultFullHttpResponse.getStatus().code() != 200) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
