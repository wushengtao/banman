/**
 *  
 *  * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 *  * @Package com.mhc.bs.common.errcode
 *  * @author: 三帝（sandi@maihaoche.com）
 *  * @date:   2018年2月27日 上午10:27:11
 *  * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 *  * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 *  
 */
package com.lunzi.batman.common;

/**
 * 全局异常枚举
 */
public enum GlobalErrorCode implements ErrorCode {

    SUCCESS("0", "OK"),
    FAILURE("-1", "Failure"),
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"), INVALID_PARAM("100", "参数错误");

    GlobalErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;

    private final String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
