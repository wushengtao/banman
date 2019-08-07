/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.bs.common.enums
 * @author: 三帝（sandi@maihaoche.com）
 * @date:   2018年3月2日 上午11:45:19
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.lunzi.batman.common;

import java.io.Serializable;

/**   
 * <p> 枚举通用接口类 </p>
 *   
 * @author: 三帝（sandi@maihaoche.com） 
 * @date: 2018年3月2日 上午11:45:19   
 * @since V1.0 
 */
public interface BaseEnum {
	/**    
	 * <p> 获取枚举类对象code </p>
	 *  
	 * @return Serializable
	 */
	Serializable getCode();
	
	/**    
	 * <p> 获取枚举类对象描述信息 </p>
	 *  
	 * @return String
	 */
	String getDesc();
}
