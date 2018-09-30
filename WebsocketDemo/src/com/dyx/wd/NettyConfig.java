package com.dyx.wd;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ProjectName: WebsocketDemo
 * @Description:
 * @Author:
 * @CreateDate: 18-9-20 下午1:57
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class NettyConfig {
    public static ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
