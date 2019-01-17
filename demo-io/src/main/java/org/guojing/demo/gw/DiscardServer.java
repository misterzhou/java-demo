package org.guojing.demo.gw;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.guojing.demo.handler.DiscardServerHandler;

/**
 * Created at: 2016-05-16
 *
 * @author guojing
 */
public class DiscardServer {

    private int port;
    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Class<? extends ServerChannel> serverChannelClass = NioServerSocketChannel.class;
    private Channel serverChannel;


    public DiscardServer() {
        this.port = 28080;
    }

    public DiscardServer(int port) {
        this.port = port;
    }

    public void init() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
    }

    public void start() {
        try {
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(serverChannelClass)
                    .handler(new LoggingHandler())
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 1024);

            serverChannel = serverBootstrap.bind(port).sync().channel();
        } catch (InterruptedException e) {
            stop();
            System.out.println(e);
        }
    }

    public void stop() {
        try {
            if (this.serverChannel != null ) {
                this.serverChannel.close().sync();
            }
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
