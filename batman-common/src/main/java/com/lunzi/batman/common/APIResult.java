/**
 *  
 *  * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 *  * @Package com.mhc.bs.common.base
 *  * @author: 三帝（sandi@maihaoche.com）
 *  * @date:   2017年11月13日 下午2:43:11
 *  * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 *  * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 *  
 */
package com.lunzi.batman.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 *
 */
@ApiModel(description = "响应结果")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResult<T> implements Serializable {

    private static final long serialVersionUID = 1922539991804940811L;
    @ApiModelProperty("调用是否成功")
    @Builder.Default
    @JSONField(ordinal = 1)
    private boolean success = true;
    @ApiModelProperty(value = "状态码", required = true)
    @Builder.Default
    @JSONField(ordinal = 2)
    private String code = "200";
    @ApiModelProperty("调用结果消息")
    @Builder.Default
    @JSONField(ordinal = 3)
    private String message = "";
    @ApiModelProperty("成功时响应数据")
    @JSONField(ordinal = 4)
    private T data;
    @ApiModelProperty(value = "时间戳", required = true, dataType = "Long")
    @Builder.Default
    @JSONField(ordinal = 5)
    private Long timestamp = System.currentTimeMillis();

    /**
     *   
     *  * <p> 返回成功结果，无返回结果集 </p>
     *  
     *  * @return APIResult<T>
     *  
     */
    public static <T> APIResult<T> ok() {
        return ok(null);
    }

    /**
     *   
     *  * <p> 返回成功结果，有返回结果集 </p>
     *  
     *  * @param data 返回结果集
     *  * @return APIResult<T>
     *  
     */
    @SuppressWarnings("unchecked")
    public static <T> APIResult<T> ok(T data) {
        return ((APIResult<T>) APIResult.builder().data(data).build());
    }

    /**
     *   
     *  * <p> 返回失败结果，默认错误码与错误提示信息 </p>
     *  
     *  * @return APIResult<T>
     *  
     */
    @SuppressWarnings("unchecked")
    public static <T> APIResult<T> error() {
        return ((APIResult<T>) APIResult.builder().success(false).code(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode())
                .message(GlobalErrorCode.INTERNAL_SERVER_ERROR.getMessage()).data(null).build());
    }

    /**
     *   
     *  * <p> 返回失败结果，默认错误码，指定错误提示信息 </p>
     *  
     *  * @param message 错误提示信息
     *  * @return APIResult<T>
     *  
     */
    @SuppressWarnings("unchecked")
    public static <T> APIResult<T> error(String message) {
        return ((APIResult<T>) APIResult.builder().success(false).code(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode())
                .message(message).data(null).build());
    }

    /**
     *   
     *  * <p> 返回失败结果，指定错误码与错误提示信息 </p>
     *  
     *  * @param code
     *  * @param message
     *  * @return APIResult<T>
     *  
     */
    @SuppressWarnings("unchecked")
    public static <T> APIResult<T> error(String code, String message) {
        return ((APIResult<T>) APIResult.builder().success(false).code(code).message(message).data(null).build());
    }

    /**
     *   
     *  * <p> 返回失败结果，根据{@link ErrorCode} 指定错误码与错误提示信息 </p>
     *  
     *  * @param errorCode {@link ErrorCode}
     *  * @return APIResult<T>
     *  
     */
    @SuppressWarnings("unchecked")
    public static <T> APIResult<T> error(ErrorCode errorCode) {
        return ((APIResult<T>) APIResult.builder().success(false).code(errorCode.getCode())
                .message(errorCode.getMessage()).data(null).build());
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
