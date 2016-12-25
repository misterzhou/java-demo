package org.guojing.core.logger;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UMSLogger {


    private static Logger debugLog = LoggerFactory.getLogger("debug");
    private static Logger infoLog = LoggerFactory.getLogger("info");
    private static Logger warnLog = LoggerFactory.getLogger("warn");
    private static Logger errorLog = LoggerFactory.getLogger("error");


    public static boolean isTraceEnabled() {
        return debugLog.isTraceEnabled();
    }

    public static boolean isDebugEnabled() {
        return debugLog.isDebugEnabled();
    }

    public static void trace(Object msg) {
        debugLog.trace(formatMsg(msg));
    }

    public static void trace(String tag, Object msg) {
        debugLog.trace(formatMsg(tag, msg));
    }

    public static void debug(Object msg) {
        if (debugLog.isDebugEnabled()) {
            debugLog.debug(formatMsg(msg));
        }
    }

    public static void debug(String tag, Object msg) {
        if (msg == null) {
            return;
        }
        if (debugLog.isDebugEnabled()) {
            debugLog.debug(formatMsg(tag, msg));
        }
    }


    public static void info(Object msg) {
        if (msg == null) {
            return;
        }
        if (infoLog.isInfoEnabled()) {
            infoLog.info(formatMsg(msg));
        }
    }

    public static void info(String tag, Object msg) {
        if (msg == null) {
            return;
        }
        if (infoLog.isInfoEnabled()) {
            infoLog.info(formatMsg(tag, msg));
        }
    }


    public static void warn(String tag, Object msg) {
        warnLog.warn(formatMsg(tag, msg));
    }
    public static void warn(String tag, Object msg, Throwable e) {
        warnLog.warn(formatMsg(tag, msg));
    }

    public static void warn(Object msg) {
        warnLog.warn(formatMsg(msg));
    }

    public static void error(String tag, Object msg, Throwable e) {
        errorLog.error(formatMsg(tag, msg), e);
    }

    public static void error(String tag, String msg) {
        errorLog.error(formatMsg(tag, msg));
    }


    private static String formatMsg(Object msg) {
        return String.format("%s", msg == null ? "null" : msg.toString());
    }

    private static String formatMsg(String tag, Object msg) {
        return String.format("%s\t%s", tag, msg == null ? "null" : msg.toString());
    }

    private   static String getStackTraceText(Throwable t) {

        if(t==null)return "";
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            return sw.toString();
        } catch (Exception e) {
            UMSLogger.nativeError(e);
        }
        return "";
    }
    //get who is calling the umslogger method
    public    static String getCallingMethod() {

        String method="";
        String last_class="";
        for( StackTraceElement s: Thread.currentThread().getStackTrace())
        {
            //System.out.println("stack:"+s.getClassName()+" file:"+s.getMethodName());
            if(last_class.endsWith("UMSLogger")&&(!s.getClassName().endsWith("UMSLogger"))){
                String[] c=StringUtils.split(s.getClassName(),".");
                if(c.length>1){
                    return c[c.length-1]+"."+s.getMethodName()+"."+s.getLineNumber();
                }
                return method;

            }

            last_class=s.getClassName();

        }
        return method;
    }
    public static void nativeError(Object msg){
        if (msg instanceof Throwable) {
            errorLog.error(formatMsg(((Throwable) msg).getMessage()), (Throwable) msg);
        } else {
            errorLog.error(formatMsg(msg));
        }
    }
    public static void nativeWarn(Object msg) {
        warnLog.warn(formatMsg(msg));
    }
    public static void nativeInfo(Object msg) {
        if (msg == null) {
            return;
        }
        if (infoLog.isInfoEnabled()) {
            infoLog.info(formatMsg(msg));
        }
    }

}
