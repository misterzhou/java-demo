package org.guojing.core.logger;

import org.apache.log4j.Logger;

/**
 * Created at: 2017-04-07 16:10
 *
 * @author guojing
 */
public class DemoLogger {

    //    private static Logger errorLog = LoggerFactory.getLogger("error");
//    private static Logger debugLog = LoggerFactory.getLogger("debug");
    private static Logger error = Logger.getLogger("error");
    private static Logger debug = Logger.getLogger("debug");


    public static void main(String[] args) {
        debug.error("error log error info");
        debug.debug("debug log debug info");
    }

}
