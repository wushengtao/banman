package com.lunzi.batman.common;

import java.io.Serializable;

/**
 * 业务异常
 *
 * @author lunzi <lunzi@maihaoche.com>
 * @date 2019/8/7 17
 */

public class BizException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -5990211151145387545L;

    /**
     * 具体异常码
     */

    protected String code;
    /**
     * 异常信息
     */
    protected String msg;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.msg = message;
    }

    public BizException(Throwable cause) {
        super(cause);
        this.msg = cause == null ? null : cause.toString();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public BizException(String code, String msg) {
        super(msg + "[" + code + "]");
        this.code = code;
        this.msg = msg;
    }

    public BizException(String code, String msg, Throwable t) {
        super(msg + "[" + code + "]", t);
        this.code = code;
        this.msg = msg;
    }

    public BizException(String code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return BizException
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public static void main(String[] args) {
        throw new BizException("123");
    }
}
