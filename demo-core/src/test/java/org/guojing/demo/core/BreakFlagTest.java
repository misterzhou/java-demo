package org.guojing.demo.core;

import org.junit.Test;

/**
 * Created at: 2016-05-13
 *
 * @author guojing
 */
public class BreakFlagTest {

    @Test
    public void testBreakFlag() {
        int n = 3;

        loop:
        for (int i = 0; i < n; i++) {
            System.out.println("start switch");
            switch (i) {
                case 0:
                    System.out.println(i);
                    break;
                case 1:
                    System.out.println(i);
                    break;
                case 2:
                    System.out.println(i);
                    //break loop;
                    if (true) {
                        continue;
                    }
                    break;
                case 3:
                    System.out.println(i);
                    break loop;
                default:
                    System.out.println("default");
                    break;
            }

            System.out.println("finish switch");
        }
    }
}
