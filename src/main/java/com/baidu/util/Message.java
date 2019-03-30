package com.baidu.util;

import lombok.Data;

/**
 * 建立一个消息类
 */
@Data
public class Message {
    private Integer code;//编码:成功为1,不成功为0
    private Object message;//消息:如果成功了,返回一些东西,如果是查询会放一些查询的信息

    public Message(Integer code, Object message) {
        this.code = code;
        this.message = message;
    }
}
