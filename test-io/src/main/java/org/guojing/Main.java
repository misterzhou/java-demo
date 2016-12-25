package org.guojing;

import org.guojing.gw.DiscardServer;
import org.guojing.gw.TimeClient;

/**
 * Created at: 2016-05-17
 *
 * @author guojing
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DiscardServer server = new DiscardServer();
        TimeClient client = new TimeClient();

        server.init();
        client.init();
        server.start();
        client.start();

        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) {
            client.getChannel().writeAndFlush("I am client " + i);
        }
    }
}
