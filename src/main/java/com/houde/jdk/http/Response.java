package com.houde.jdk.http;

import lombok.Data;

/**
 * @author qiukun
 * @create 2019-02-12 17:25
 */
@Data
public class Response {
    private int code;

    private String version;

    private String contentType;

    private String server;


}
