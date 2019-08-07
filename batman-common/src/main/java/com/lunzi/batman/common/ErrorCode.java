/**
 *  
 *  * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 *  * @Package com.mhc.bs.common.errcode
 *  * @author: 三帝（sandi@maihaoche.com）
 *  * @date:   2018年2月27日 上午10:25:08
 *  * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 *  * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 *  
 */
package com.lunzi.batman.common;

public interface ErrorCode {
    /**  
      * <p> 获取错误码 </p>
     * 
      * @return
      */
    String getCode();

    /**  
      * <p> 获取错误信息 </p>
     * 
      * @return
      */
    String getMessage();
}
