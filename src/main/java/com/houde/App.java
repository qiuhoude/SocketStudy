package com.houde;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        log.debug("啦啦啦");
        log.error("错误 {}", 11);
    }
}
