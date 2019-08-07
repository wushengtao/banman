package com.lunzi.batman.core.enums;

import com.lunzi.batman.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 本系统的错误码枚举,所有错误信息统一维护和公布
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum implements BaseEnum {

    SUCCESS("1001", "成功"),
    NO_DATA("1002", "无数据"),
    PARAM_ERROR("1003", "参数错误"),
    INSERT_FAIL("1004", "插入数据错误"),
    QUERY_FAIL("1005", "查询错误"),
    UPDATE_FAIL("1006", "修改数据错误"),
    DATA_ERROR("1008", "数据异常"),
    DUPLICATE_ERROR("1009", "重复操作"),
    NO_AUTH("1010", "没有权限"),
    BIZ_EXCEPTION("8888", "业务异常"),
    EXCEPTION("9999", "系统异常");

    /**
     * 错误码
     */
    public final String code;

    /**
     * 错误消息
     */
    public final String desc;
}

