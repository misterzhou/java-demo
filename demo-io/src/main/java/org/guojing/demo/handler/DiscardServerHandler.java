package org.guojing.demo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created at: 2016-05-17
 *
 * @author guojing
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("from client: " + buf.toString());
        buf.alloc().buffer(4);
        buf.writeLong(System.currentTimeMillis());
        ctx.writeAndFlush(buf);
    }
}
