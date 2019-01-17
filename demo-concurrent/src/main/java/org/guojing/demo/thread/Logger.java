package org.guojing.demo.thread;

/**
 * Created at: 2016-04-16
 *
 * @author guojing
 */
public class Logger {

    private String requestID;

    private String respCode;

    public Logger() {

    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    @Override
    public String toString() {
        return "requestID: " + requestID + ", respCode: " + respCode;
    }
}
