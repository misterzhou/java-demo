package org.guojing.demo.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Calendar;

/**
 * Created at: 2016-04-09
 *
 * @author guojing
 */
public class IOTest {

    @Test
    public void simple() throws Exception {
        String header = "header";
        String body = "body";
        String content = "java nio demo";
        File file = new File("nio_test.txt");
        IOUtils.write(content, new FileOutputStream(file));

        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int n = channel.read(buf);
        while (n != -1) {
            buf.flip(); //从write mode转变为read mode
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            n = channel.read(buf);
        }
        channel.close();
    }

    @Test
    public void testSelector() {

    }

    @Test
    public void testCalendr() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTimeInMillis());
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
    }

    @Test
    public void testString() {
        char[] str = "abc".toCharArray();
        permutation(str, 0, str.length - 1);
    }

    private void permutation(char[] str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i < end; i++) {
                swap(str, start, i);
                permutation(str, start + 1, end);
                swap(str, start, i);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        if (str[i] == str[j]) {
            return;
        }
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
