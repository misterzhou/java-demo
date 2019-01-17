package org.guojing.demo.gw;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created at: 2016-05-17
 *
 * @author guojing
 */
public class TimeClient {

    private String host;
    private int port;
    private EventLoopGroup workerGroup;
    private Bootstrap bootstrap;
    private Channel channel;

    public TimeClient() {
        this.host = "127.0.0.1";
        this.port = 28080;
    }

    public void init() {
        workerGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
    }

    public void start() {
        try {
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast();
                        }
                    });

            channel = bootstrap.connect(host, port).sync().channel();
        } catch (Exception e) {
            stop();
            System.out.println(e);
        }
    }

    public void stop() {
        try {
            if (channel != null) {
                channel.close().sync();
            }
            workerGroup.shutdownGracefully();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Channel getChannel() {
        return channel;
    }

}
