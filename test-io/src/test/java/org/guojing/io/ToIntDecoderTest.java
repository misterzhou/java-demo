package org.guojing.io;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.guojing.netty.codec.ToIntDecoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

/**
 * Created at: 2018-07-12 12:03
 *
 * @author guojing
 */
public class ToIntDecoderTest {

    @Test
    public void name() {
        EmbeddedChannel channel = new EmbeddedChannel(new ToIntDecoder());
        ByteBuf originalBuf = Unpooled.buffer();
        originalBuf.writeInt(1);
        originalBuf.writeInt(2);
        originalBuf.writeInt(3);
        originalBuf.writeInt(4);

        ByteBuf byteBuf = originalBuf.duplicate();
        boolean writeInbound = channel.writeInbound(byteBuf);
        Assert.assertTrue(writeInbound);
        channel.finish();

        Queue<Object> messages = channel.inboundMessages();
        for (Object message : messages) {
            Integer intValue = (Integer) channel.readInbound();
            Assert.assertEquals(message, intValue);
        }
    }
}
