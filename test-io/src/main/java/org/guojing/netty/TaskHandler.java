package org.guojing.netty;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created at: 2018-05-30 17:15
 *
 * @author guojing
 */
public class TaskHandler implements Runnable {

    SocketChannel socketChannel;
    Selector selector;

    public TaskHandler() {}

    public TaskHandler(SocketChannel socketChannel, Selector selector) throws IOException {
        this.socketChannel = socketChannel;
        this.socketChannel.configureBlocking(false);

        SelectionKey selectionKey = socketChannel.register(selector, 0, this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {

    }
}
