package com.lunzi.batman.aop;

import com.lunzi.batman.common.APIResult;
import com.lunzi.batman.common.BizException;
import com.lunzi.batman.core.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * 全局异常捕获
 *
 * @author lunzi <lunzi@maihaoche.com>
 * @date 2019/8/7 15
 */
@Slf4j
@RestControllerAdvice()
@Order(-99)
public class RestControllerAspect {

    /**
     *   
     *  * <p> Exception异常处理 </p>
     *  
     *  * @param ex Exception异常
     *  * @return APIResult<T>
     *  
     */
    @ExceptionHandler
    private <T> APIResult<T> exceptionHandler(Exception ex, HttpServletRequest request) {
        log.error(request.getRequestURI() + " " + ex.getMessage(), ex);
        return APIResult.error(ErrorCodeEnum.EXCEPTION.code, ex.getMessage());
    }

    /**
     *   
     *  * <p> BizException 异常处理</p>
     *  
     *  * @param bizEx BizException异常
     *  * @return APIResult<T>
     *  
     */
    @ExceptionHandler(value = {BizException.class})
    private <T> APIResult<T> bizExceptionHandler(BizException bizEx, HttpServletRequest request) {
        log.warn(request.getRequestURI() + " " + bizEx.getMsg());
        return APIResult.error(bizEx.getCode(), bizEx.getMsg());
    }


    /**
     *   
     *  * <p> BindException 异常处理</p>
     *  
     *  * @param bindEx BindException
     *  * @return APIResult<T>
     *  
     */
    @ExceptionHandler(BindException.class)
    private <T> APIResult<T> bindExceptionHandler(BindException bindEx, HttpServletRequest request) {
        BindingResult br = bindEx.getBindingResult();
        if (br.hasErrors()) {
            String errMsg = String.join(",", br.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList()));
            log.warn(request.getRequestURI() + " " + errMsg);
            return APIResult.error(ErrorCodeEnum.PARAM_ERROR.code, errMsg);
        }
        return APIResult.error(ErrorCodeEnum.PARAM_ERROR.code, ErrorCodeEnum.PARAM_ERROR.desc);
    }

    /**
     *   
     *  * <p> ServletRequestParameterException 异常处理</p>
     *  * @param ex Exception
     *  * @return APIResult<T>
     *  
     */
    @ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class, HttpRequestMethodNotSupportedException.class})
    private <T> APIResult<T> missingServletRequestParameterExceptionHandler(Exception ex, HttpServletRequest request) {
        log.warn(request.getRequestURI() + " " + ex.getMessage());
        return APIResult.error(ErrorCodeEnum.PARAM_ERROR.code, ex.getMessage());

    }
}
