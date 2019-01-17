package org.guojing.demo.core;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by guojing on 16/12/30.
 */
public class SignatureTest {

    @Test
    public void signature() {
        try {
            String accessKey = "*******";
            String secret = "*********";
            String message = generateData(accessKey);
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(hash);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String generateData(String accessKey) {
        StringBuilder builder = new StringBuilder();
        builder.append("POST");
        builder.append('\n');
        builder.append("mosapi.meituan.com");
        builder.append('\n');
        builder.append("/mcs/v1");
        builder.append('\n');
        builder.append("AWSAccessKeyId=" + accessKey);
        builder.append('&');
        builder.append("Action=DescribeTemplates&Format=json&SignatureMethod=HmacSHA256&SignatureVersion=2&Timestamp=2016-30-30T18%3A43%3A35");
        return builder.toString();
    }
}